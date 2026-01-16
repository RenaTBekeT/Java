package com.movieApp.service;

import com.movieApp.model.Movie;
import com.movieApp.model.User;
import com.movieApp.model.UserMovie;
import com.movieApp.repository.MovieRepository;
import com.movieApp.repository.UserMovieRepository;
import com.movieApp.repository.UserRepository;
import com.movieApp.service.dto.OmdbMovieDetail;
import com.movieApp.service.dto.OmdbSearchItem;
import com.movieApp.service.dto.OmdbSearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.text.Normalizer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovieService {

    private final UserRepository usersRepository;
    private final MovieRepository movieRepository;
    private final UserMovieRepository userMovieRepository;
    private final RestClient restClient;

    @Value("${omdb.api.key}")
    private String omdbApiKey;

    public MovieService(UserRepository usersRepository,
                        MovieRepository movieRepository,
                        UserMovieRepository userMovieRepository,
                        RestClient.Builder restClientBuilder) {
        this.usersRepository = usersRepository;
        this.movieRepository = movieRepository;
        this.userMovieRepository = userMovieRepository;
        this.restClient = restClientBuilder.baseUrl("https://www.omdbapi.com").build();
    }

    public User register(String username, String password) {
        if (usersRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already in used");
        }
        return usersRepository.save(new User(username, password));
    }

    public Boolean isUser(String username, String password) {
        User user = usersRepository.findByUsername(username);
        if (user == null) throw new IllegalArgumentException("No username found");
        if (!user.getPassword().equals(password)) throw new IllegalArgumentException("Password not match");
        return true;
    }

    public List<OmdbSearchItem> searchOmdb(String rawQuery) {
        if (rawQuery == null) return Collections.emptyList();

        String q = normalizeQuery(rawQuery);
        if (q.isBlank()) return Collections.emptyList();

        OmdbSearchResponse resp = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("apikey", omdbApiKey)
                        .queryParam("s", q)
                        .build())
                .retrieve()
                .body(OmdbSearchResponse.class);

        if (resp == null || resp.getSearch() == null) return Collections.emptyList();
        return resp.getSearch();
    }

    private String normalizeQuery(String input) {
        String trimmed = input.trim().toLowerCase();
        String normalized = Normalizer.normalize(trimmed, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}", "");
    }

    public OmdbMovieDetail getOmdbDetail(String imdbId) {
        if (imdbId == null || imdbId.isBlank()) return null;

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("apikey", omdbApiKey)
                        .queryParam("i", imdbId)
                        .queryParam("plot", "full")
                        .build())
                .retrieve()
                .body(OmdbMovieDetail.class);
    }

    public void addToMyMovies(String username, String imdbId) {
        if (username == null || username.isBlank()) return;
        if (imdbId == null || imdbId.isBlank()) return;

        User user = usersRepository.findByUsername(username);
        if (user == null) return;

        Movie movie = movieRepository.findByImdbId(imdbId);

        if (movie == null) {
            OmdbMovieDetail d = getOmdbDetail(imdbId);
            if (d == null) return;

            movie = new Movie();
            movie.setImdbId(d.getImdbId());
            movie.setTitle(d.getTitle());
            movie.setGenre(d.getGenre());
            movie.setDescription(d.getPlot());
            movie.setPosterUrl(d.getPoster());

            try {
                movie.setYear(Integer.parseInt(d.getYear()));
            } catch (Exception ignored) {
                movie.setYear(null);
            }

            movieRepository.save(movie);
        }

        if (userMovieRepository.countByUserAndMovie(user, movie) > 0) return;

        userMovieRepository.save(new UserMovie(user, movie));
    }

    public List<UserMovie> getMyMovies(String username) {
        User user = usersRepository.findByUsername(username);
        if (user == null) return List.of();
        return userMovieRepository.findAllByUser(user);
    }

    // ✅ TADY je to, co ti chybí: set imdbId ve favourites
    public java.util.Set<String> getFavouriteImdbIds(String username) {
        User user = usersRepository.findByUsername(username);
        if (user == null) return java.util.Set.of();

        return userMovieRepository.findAllByUser(user).stream()
                .filter(um -> um.getMovie() != null && um.getMovie().getImdbId() != null)
                .map(um -> um.getMovie().getImdbId())
                .collect(java.util.stream.Collectors.toSet());
    }

    public void deleteFromFavourites(String username, long userMovieId) {
        if (username == null || username.isBlank()) return;

        User user = usersRepository.findByUsername(username);
        if (user == null) return;

        UserMovie um = userMovieRepository.findById(userMovieId).orElse(null);
        if (um == null) return;

        // bezpečnost: smažeš jen to, co patří tomuhle userovi
        if (um.getUser() == null || um.getUser().getId() != user.getId()) return;

        userMovieRepository.delete(um);
    }
    public boolean toggleFavourite(String username, String imdbId) {
        if (username == null || username.isBlank()) return false;
        if (imdbId == null || imdbId.isBlank()) return false;

        User user = usersRepository.findByUsername(username);
        if (user == null) return false;

        Movie movie = movieRepository.findByImdbId(imdbId);

        // když movie není v DB, tak to nejde smazat – ale jde uložit
        if (movie == null) {
            OmdbMovieDetail d = getOmdbDetail(imdbId);
            if (d == null) return false;

            movie = new Movie();
            movie.setImdbId(d.getImdbId());
            movie.setTitle(d.getTitle());
            movie.setGenre(d.getGenre());
            movie.setDescription(d.getPlot());
            movie.setPosterUrl(d.getPoster());
            try { movie.setYear(Integer.parseInt(d.getYear())); } catch (Exception ignored) {}

            movieRepository.save(movie);
        }

        // existuje už spojení user+movie?
        UserMovie existing = userMovieRepository.findByUserAndMovie(user, movie);
        if (existing != null) {
            userMovieRepository.delete(existing);
            return false; // teď je to odstraněné
        }

        userMovieRepository.save(new UserMovie(user, movie));
        return true; // teď je to uložené
    }
}
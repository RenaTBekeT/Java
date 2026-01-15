package com.movieApp.service;

import com.movieApp.model.User;
import com.movieApp.repository.UserRepository;
import com.movieApp.service.dto.OmdbSearchItem;
import com.movieApp.service.dto.OmdbSearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.text.Normalizer;
import java.util.Collections;
import java.util.List;

@Service
public class MovieService {

    private final UserRepository usersRepository;
    private final RestClient restClient;

    @Value("${omdb.api.key}")
    private String omdbApiKey;

    public MovieService(UserRepository usersRepository, RestClient.Builder restClientBuilder) {
        this.usersRepository = usersRepository;
        this.restClient = restClientBuilder
                .baseUrl("https://www.omdbapi.com")
                .build();
    }

    public User register(String username, String password) {
        if (usersRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already in used");
        }
        User user = new User(username, password);
        return usersRepository.save(user);
    }

    public Boolean isUser(String username, String password) {
        User user = usersRepository.findByUsername(username);
        if (user == null) throw new IllegalArgumentException("No username found");
        if (!user.getPassword().equals(password)) throw new IllegalArgumentException("Password not match");
        return true;
    }

    // ✅ OMDb search
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
}
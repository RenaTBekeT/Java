package movies.com.example.movies.Services;

import movies.com.example.movies.models.Movie;
import movies.com.example.movies.models.User;
import movies.com.example.movies.models.Vote;
import movies.com.example.movies.repositories.MovieRepository;
import movies.com.example.movies.repositories.UserRepository;
import movies.com.example.movies.repositories.MovieRepository;
import movies.com.example.movies.repositories.VotesRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    VotesRepository votesRepository;

    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public void addNewMovie(Integer year, String genre, String title, Integer duration, Double ranking, String url) {
        Movie movie = new Movie(year, genre, title, duration, ranking, url);
        movieRepository.save(movie);
    }

    public Boolean isUser(String username) {
        if (username == null) {
            return false;
        }
        User user = userRepository.findByUsername(username);
        return user != null;
    }

    public Vote createVote(boolean direction, long id, String username) {
        User user = userRepository.findByUsername(username);
        Movie movie = movieRepository.findMovieById(id);
        Vote newVote = new Vote(direction);
        newVote.setUser(user);
        newVote.setMovie(movie);
        votesRepository.save(newVote);
        return newVote;
    }

    public boolean isPresent(String username, Long movieId) {
        User user = userRepository.findByUsername(username);
        long UserId = user.getId();
        return votesRepository.findByUserIdAndMovieId(UserId, movieId).isPresent();
    }

    public void remove(String username, Long postId) {
        long voteId = getVoteId(username, postId);
        if (voteId == 0) {
            return;
        }
        votesRepository.deleteById(voteId);
    }

    public long getVoteId(String username, Long movieId) {
        User user = userRepository.findByUsername(username);
        Long Userid = user.getId();
        Optional<Vote> optionalVote = votesRepository.findByUser_IdAndMovie_Id(Userid, movieId);
        return optionalVote.map(Vote::getId).orElse(0L);
    }

    public long getVoteCountByMovieId(long postId) {
        return votesRepository.countVotesByMovie_Id(postId);
    }

    public Iterable<Movie> findAllPostAndAssignNumberOfLikes() {
        Iterable<Movie> allPosts = movieRepository.findAll();
        List<Long[]> likes = votesRepository.getMovieVoteCounts();
        for (Movie movie : getAllMovies()) {
            long postId = movie.getId();
            for (Long[] like : likes) {
                if (like[0] == postId) {
                    movie.setLikes(like[1]);
                    break;
                }
            }
        }

        return allPosts;
    }
}
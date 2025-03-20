import movies.com.example.movies.MoviesApplication;
import movies.com.example.movies.models.Movie;
import movies.com.example.movies.repositories.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest(classes = MoviesApplication.class)
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void printAllMovies() {
        List<Movie> movies = (List<Movie>) movieRepository.findAll();
        System.out.println("Total movies found: " + movies.size());  // Add this line
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
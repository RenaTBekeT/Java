package movies.com.example.movies.repositories;

import movies.com.example.movies.models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    Movie findByTitle(String title);
    Movie findMovieById(long id);
}

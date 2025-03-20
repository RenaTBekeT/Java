package movies.com.example.movies.repositories;

import movies.com.example.movies.Services.MovieService;
import movies.com.example.movies.models.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VotesRepository extends CrudRepository<Vote, Long> {

    Optional<Vote> findByUser_IdAndMovie_Id(Long userId, Long movieId);

    long countVotesByMovie_Id(long movieId);

    @Query("SELECT v.movie.id, COUNT(v) FROM Vote v GROUP BY v.movie.id")
    List<Long[]> getMovieVoteCounts();

    Optional<Vote> findByUserIdAndMovieId(long userId, long movieId); // korektní metoda
}

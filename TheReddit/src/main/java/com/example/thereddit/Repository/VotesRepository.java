package com.example.thereddit.Repository;

import com.example.thereddit.Model.Post;
import com.example.thereddit.Model.Vote;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VotesRepository extends CrudRepository<Vote, Long> {

    Optional<Vote> findByUserIdAndPostId(long userId, long postId);
   // void deleteByIdAndUserId(long id, long userId);
    long countVotesByPostId(long postId);
    @Query("SELECT v.post.id, COUNT(v) FROM Vote v GROUP BY v.post.id")
    List<Long[]> getPostVoteCounts();

}



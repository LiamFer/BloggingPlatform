package com.liamfer.BloggingPlatform.Repository;

import com.liamfer.BloggingPlatform.Models.PostModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<PostModel,Long> {
    @Query("SELECT p FROM PostModel p WHERE p.title LIKE %:term% OR p.content LIKE %:term% OR p.category LIKE %:term%")
    List<PostModel> findPostContaining(@Param("term") String term);
}

package com.liamfer.BloggingPlatform.Repository;

import com.liamfer.BloggingPlatform.Models.PostModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<PostModel,Long> {

}

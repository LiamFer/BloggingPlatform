package com.liamfer.BloggingPlatform.Service;

import com.liamfer.BloggingPlatform.Models.PostModel;
import com.liamfer.BloggingPlatform.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public PostModel createPost(PostModel newPost){
        return repository.save(newPost);
    }
}

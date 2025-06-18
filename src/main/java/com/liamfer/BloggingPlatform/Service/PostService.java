package com.liamfer.BloggingPlatform.Service;

import com.liamfer.BloggingPlatform.Exceptions.ResourceNotFoundException;
import com.liamfer.BloggingPlatform.Models.PostModel;
import com.liamfer.BloggingPlatform.Repository.PostRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public PostModel createPost(PostModel newPost){
        return repository.save(newPost);
    }

    public Iterable<PostModel> getAllPosts(String term){
        return repository.findPostContaining(term);
    }

    public PostModel getPostById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post não encontrado!"));
    }

    public PostModel updatePost(PostModel postBody){
        PostModel post = repository.findById(postBody.getId()).orElseThrow(() -> new ResourceNotFoundException("Post não encontrado!"));

        post.setTitle(postBody.getTitle());
        post.setContent(postBody.getContent());
        post.setCategory(postBody.getCategory());
        post.setTags(postBody.getTags());

        return repository.save(post);
    }

    public void deletePost(Long id){
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post não encontrado!"));
        repository.deleteById(id);
    }

}

package com.liamfer.BloggingPlatform.Controller;

import com.liamfer.BloggingPlatform.Models.PostModel;
import com.liamfer.BloggingPlatform.Service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;
    PostController(PostService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<Iterable<PostModel>> getPosts(@RequestParam(value = "term",defaultValue = "") String term){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllPosts(term));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostModel> getPost(@PathVariable("id") Long id, @RequestParam("term") String term){
        return ResponseEntity.status(HttpStatus.OK).body(service.getPostById(id));
    }

    @PostMapping()
    public ResponseEntity<PostModel> newPost(@Valid @RequestBody PostModel body){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPost(body));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostModel> editPost(@PathVariable("id") Long id,@Valid @RequestBody PostModel body){
        body.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(service.updatePost(body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long id){
        service.deletePost(id);
        return ResponseEntity.noContent().build();
    }


}

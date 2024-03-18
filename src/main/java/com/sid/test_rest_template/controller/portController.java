package com.sid.test_rest_template.controller;

import com.sid.test_rest_template.model.Post;
import com.sid.test_rest_template.service.PostClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class portController {
    @Autowired
    private PostClient postClient;

    @GetMapping("/posts")
    public ResponseEntity<Post[]> getAllPosts(){
        return postClient.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        return postClient.getPostById(id);
    }

    @PostMapping("/posts")
        public ResponseEntity<Post> addPost(@RequestBody Post post){
        return postClient.addPost(post);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Void> addPost(@PathVariable Long id, @RequestBody Post post){
        return postClient.updatePost(id,post);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> addPost(@PathVariable Long id){
        return postClient.deletePost(id);
    }

}

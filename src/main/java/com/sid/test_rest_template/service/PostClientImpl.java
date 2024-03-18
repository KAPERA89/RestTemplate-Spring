package com.sid.test_rest_template.service;

import com.sid.test_rest_template.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostClientImpl implements PostClient {
    @Autowired
    RestTemplate restTemplate;
    final String url = "https://jsonplaceholder.typicode.com/posts";

    @Override
    public ResponseEntity<Post[]> getAllPosts() {
        //ResponseEntity<Post> response = restTemplate.getForEntity(url, Post.class);
        Post[] response = restTemplate.getForObject(url, Post[].class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Post> getPostById(Long id) {
        Post post = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/"+id, Post.class);
        return ResponseEntity.ok(post);
    }

    @Override
    public ResponseEntity<Post> addPost(Post post) {
        Post createdPost = restTemplate.postForObject(url, post, Post.class);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updatePost(Long id, Post updatedPost) {
        restTemplate.put("https://jsonplaceholder.typicode.com/posts/"+id, id, updatedPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deletePost(Long id) {
        restTemplate.delete("https://jsonplaceholder.typicode.com/posts/"+id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

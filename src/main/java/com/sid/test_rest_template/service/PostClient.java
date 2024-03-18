package com.sid.test_rest_template.service;

import com.sid.test_rest_template.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface PostClient {
    ResponseEntity<Post[]> getAllPosts();

    ResponseEntity<Post> getPostById(Long id);

    ResponseEntity<Post> addPost(Post post);
    ResponseEntity<Void> updatePost(Long id, Post post);

    ResponseEntity<Void> deletePost(Long id);
}

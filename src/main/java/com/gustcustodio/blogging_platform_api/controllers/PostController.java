package com.gustcustodio.blogging_platform_api.controllers;

import com.gustcustodio.blogging_platform_api.dtos.PostDTO;
import com.gustcustodio.blogging_platform_api.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> getSinglePost(@PathVariable Long id) {
        PostDTO postDTO = postService.getSinglePost(id);
        return ResponseEntity.ok(postDTO);
    }

}

package com.gustcustodio.blogging_platform_api.controllers;

import com.gustcustodio.blogging_platform_api.dtos.PostDTO;
import com.gustcustodio.blogging_platform_api.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<PostDTO> postDTOList = postService.getAllPosts();
        return ResponseEntity.ok().body(postDTOList);
    }

    @PostMapping
    public ResponseEntity<PostDTO> createNewPost(@RequestBody PostDTO postDTO) {
        postDTO = postService.createNewPost(postDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(postDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(postDTO);
    }

}

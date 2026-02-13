package com.gustcustodio.blogging_platform_api.controllers;

import com.gustcustodio.blogging_platform_api.dtos.PostDTO;
import com.gustcustodio.blogging_platform_api.services.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<PostDTO> createNewPost(@Valid @RequestBody PostDTO postDTO) {
        postDTO = postService.createNewPost(postDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(postDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(postDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long id, @Valid @RequestBody PostDTO postDTO) {
        postDTO = postService.updatePost(id, postDTO);
        return ResponseEntity.ok(postDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

}

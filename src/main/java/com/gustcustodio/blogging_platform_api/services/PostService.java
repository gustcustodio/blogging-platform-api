package com.gustcustodio.blogging_platform_api.services;

import com.gustcustodio.blogging_platform_api.dtos.PostDTO;
import com.gustcustodio.blogging_platform_api.entities.Post;
import com.gustcustodio.blogging_platform_api.mappers.PostMapper;
import com.gustcustodio.blogging_platform_api.repositories.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    private PostMapper postMapper;

    public PostService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Transactional(readOnly = true)
    public PostDTO getSinglePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        PostDTO postDTO = postMapper.convertEntityToDto(post);
        return postDTO;
    }

    @Transactional(readOnly = true)
    public List<PostDTO> getAllPosts() {
        List<Post> postList = postRepository.findAll();
        return postMapper.convertEntityListToDtoList(postList);
    }

}

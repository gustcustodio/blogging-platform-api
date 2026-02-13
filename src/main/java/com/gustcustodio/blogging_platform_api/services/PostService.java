package com.gustcustodio.blogging_platform_api.services;

import com.gustcustodio.blogging_platform_api.dtos.PostDTO;
import com.gustcustodio.blogging_platform_api.entities.Post;
import com.gustcustodio.blogging_platform_api.mappers.PostMapper;
import com.gustcustodio.blogging_platform_api.repositories.PostRepository;
import com.gustcustodio.blogging_platform_api.services.exceptions.DatabaseException;
import com.gustcustodio.blogging_platform_api.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        return postMapper.convertEntityToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostDTO> getAllPosts() {
        List<Post> postList = postRepository.findAll();
        return postMapper.convertEntityListToDtoList(postList);
    }

    @Transactional
    public PostDTO createNewPost(PostDTO postDTO) {
        Post post = postMapper.convertDtoToEntity(postDTO);
        post = postRepository.save(post);
        return postMapper.convertEntityToDto(post);
    }

    @Transactional
    public PostDTO updatePost(Long id, PostDTO postDTO) {
        try {
            Post post = postRepository.getReferenceById(id);
            postMapper.updateEntityFromDto(postDTO, post);
            post = postRepository.save(post);
            return postMapper.convertEntityToDto(post);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Resource not found");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found");
        }
        try {
            postRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential integrity failure");
        }
    }

}

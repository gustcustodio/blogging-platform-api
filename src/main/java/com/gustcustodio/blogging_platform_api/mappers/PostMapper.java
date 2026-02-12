package com.gustcustodio.blogging_platform_api.mappers;

import com.gustcustodio.blogging_platform_api.dtos.PostDTO;
import com.gustcustodio.blogging_platform_api.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PostMapper {

    Post convertDtoToEntity(PostDTO postDTO);

    PostDTO convertEntityToDto(Post post);

    List<PostDTO> convertEntityListToDtoList(List<Post> posts);

    void updateEntityFromDto(PostDTO postDTO, @MappingTarget Post post);

}

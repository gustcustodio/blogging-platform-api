package com.gustcustodio.blogging_platform_api.mappers;

import com.gustcustodio.blogging_platform_api.dtos.PostDTO;
import com.gustcustodio.blogging_platform_api.entities.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post convertDtoToEntity(PostDTO postDTO);

    PostDTO convertEntityToDto(Post post);

}

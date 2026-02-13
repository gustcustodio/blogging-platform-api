package com.gustcustodio.blogging_platform_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDTO {

    private Long id;

    @Size(min = 5, max = 50, message = "The title needs to be between 5 and 50 characters")
    @NotBlank(message = "Required field")
    private String title;

    @Size(min = 10, message = "The content must have at least 10 characters")
    @NotBlank(message = "Required field")
    private String content;

    @Size(min = 3, message = "The category must have at least 3 characters")
    @NotBlank(message = "Required field")
    private String category;

    @Size(min = 1, message = "The post must have at least one tag")
    private List<@NotBlank(message = "Each tag must have a name") @Size(min = 3, message = "Each tag must have at least 3 characters") String> tags = new ArrayList<String>();

    private Instant createdAt;

    private Instant updatedAt;

}

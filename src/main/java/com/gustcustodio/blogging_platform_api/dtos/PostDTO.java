package com.gustcustodio.blogging_platform_api.dtos;

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
    private String title;
    private String content;
    private String category;
    private List<String> tags = new ArrayList<String>();
    private Instant createdAt;
    private Instant updatedAt;

}

package com.gustcustodio.blogging_platform_api.repositories;

import com.gustcustodio.blogging_platform_api.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}

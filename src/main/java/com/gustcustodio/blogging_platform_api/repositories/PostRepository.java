package com.gustcustodio.blogging_platform_api.repositories;

import com.gustcustodio.blogging_platform_api.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(nativeQuery = true, value = """
                SELECT * FROM tb_post
                WHERE LOWER(title) LIKE LOWER(CONCAT('%', :term, '%')) 
                   OR LOWER(content) LIKE LOWER(CONCAT('%', :term, '%')) 
                   OR LOWER(category) LIKE LOWER(CONCAT('%', :term, '%'))
            """)
    List<Post> searchByTerm(String term);

}

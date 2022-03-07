package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface PostRepository extends JpaRepository<Post,Long> {
    Optional<Post> findByTitle(String title);


}

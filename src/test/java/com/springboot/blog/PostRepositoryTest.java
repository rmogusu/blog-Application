package com.springboot.blog;

import com.springboot.blog.entity.Post;
import com.springboot.blog.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    // JUnit test for savePost
    @Test
    @Order(1)
    @Rollback(value = false)
    public void savePostTest(){
        Post post = Post.builder()
                .title("my name is Rose")
                .description("I like jumping in the morning")
                .content("this is pretty good")
                .build();

        postRepository.save(post);
        Assertions.assertThat(post.getId()).isGreaterThan(0);
    }
    @Test
    @Order(2)
    public void getPostTest(){
        Post post = postRepository.findById(1L).get();

        Assertions.assertThat(post.getId()).isEqualTo(1L);

    }
    @Test
    @Order(3)
    public void getListOfPostTest(){

        List<Post> post = postRepository.findAll();

        Assertions.assertThat(post.size()).isGreaterThan(0);

    }

}

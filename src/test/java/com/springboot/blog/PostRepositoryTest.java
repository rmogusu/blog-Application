package com.springboot.blog;

import com.springboot.blog.entity.Post;
import com.springboot.blog.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

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

}

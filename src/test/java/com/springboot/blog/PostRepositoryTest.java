package com.springboot.blog;

import com.springboot.blog.entity.Post;
import com.springboot.blog.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootBlogRestApiApplication.class)
public class PostRepositoryTest {


    @Autowired
    PostRepository postRepository;

    // JUnit test for savePost
    @Test
    @DirtiesContext
    public void savePostTest() {
        Post post = Post.builder()
                .title("my name is Rose")
                .description("I like jumping in the morning")
                .content("this is pretty good")
                .build();

        postRepository.save(post);
        Assertions.assertThat(post.getId()).isGreaterThan(0);
    }

   //Junit test to get post by id
    @Test
    @DirtiesContext
    public void getPostTest() {
        Post post = postRepository.findById(1L).get();

        Assertions.assertThat(post.getId()).isEqualTo(1L);

    }
  //junit to get all posts
    @Test
    @DirtiesContext
    public void getListOfPostTest() {

        List<Post> post = postRepository.findAll();

        Assertions.assertThat(post.size()).isGreaterThan(0);

    }
  //junit to update all post by id
    @Test
    @Rollback(value = false)
    @DirtiesContext
    public void updatePostTest() {

        Post post = postRepository.findById(2L).get();

        post.setTitle("Stop all that you are doing");

        Post postUpdated = postRepository.save(post);

        Assertions.assertThat(postUpdated.getTitle()).isEqualTo("Stop all that you are doing");

    }
    //junit to delete post by id
    @Test
    @Order(5)
    @DirtiesContext
    public void deletePostTest(){

        Post post = postRepository.findById(1L).get();

        postRepository.delete(post);

        //postRepository.deleteById(1L);

        Post post1 = null;

        Optional<Post> optionalPost = postRepository.findByTitle("Stop all that you are doing");

        if(optionalPost.isPresent()){
            post1 = optionalPost.get();
        }

        Assertions.assertThat(post1).isNull();
    }


}

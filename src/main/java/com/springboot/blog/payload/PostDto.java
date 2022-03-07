package com.springboot.blog.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;


//@ApiModel(description = "Post model information")
@Data
public class PostDto {
//    @ApiModelProperty(value = "Blog post id")
    private long id;

    // title should not be null  or empty
    // title should have at least 2 characters
//    @ApiModelProperty(value = "Blog post title")
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;

    // post description should be not null or empty
    // post description should have at least 10 characters
//    @ApiModelProperty(value = "Blog post description")
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;

    // post content should not be null or empty
//    @ApiModelProperty(value = "Blog post conent")
    @NotEmpty
    @Size(min = 10, message = "Content description should have at least 5 characters")
    private String content;

//    @ApiModelProperty(value = "Blog post comments")
    private Set<CommentDto> comments;
}


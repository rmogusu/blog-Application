package com.springboot.blog.payload;

import lombok.Data;

@Data
public class CommentDto {
//    @ApiModelProperty(value = "Comment id")
    private long id;
    // name should not be null or empty
//    @ApiModelProperty(value = "Comment name")
    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    // email should not be null or empty
    // email field validation
//    @ApiModelProperty(value = "Comment email")
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;

    // comment body should not be bull or empty
    // Comment body must be minimum 10 characters
    @NotEmpty
//    @ApiModelProperty(value = "Comment body")
    @Size(min = 10, message = "Comment body must be minimum 10 characters")
    private String body;
}
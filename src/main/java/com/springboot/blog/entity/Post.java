package com.springboot.blog.entity;


import ch.qos.logback.classic.db.names.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post", uniqueConstraints = {uniqueConstrait(columnNames = {"title"})})
public class Post {
    private Long id;
    private String title;
    private String description;
    private String content;
}

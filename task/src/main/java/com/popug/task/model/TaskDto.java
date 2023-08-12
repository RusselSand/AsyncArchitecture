package com.popug.task.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Integer id;
    private String name;
    private String description;
    private String user;
    private String userId;
    private Integer price;
    private String publicId;
}

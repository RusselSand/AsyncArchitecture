package com.popug.task.model;

import org.springframework.stereotype.Service;

@Service
public class TaskMapper {
    public TaskDto toDto(Task entity){
        return new TaskDto(entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getAssignee().getName(),
                entity.getAssignee().getPublicId(),
                entity.getPrice(),
                entity.getPublicId());
    }
}

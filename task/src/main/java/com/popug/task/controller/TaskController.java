package com.popug.task.controller;

import com.popug.task.model.TaskDto;
import com.popug.task.request.CreateTaskRequest;
import com.popug.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    @GetMapping("/get/{id}")
    public ResponseEntity<TaskDto> getById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.getTaskById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskDto>> getAll(){
        return new ResponseEntity<>(service.getAllTasks(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<TaskDto> addTask(@RequestBody CreateTaskRequest request){
        return ResponseEntity.ok(service.addTask(request));
    }
}

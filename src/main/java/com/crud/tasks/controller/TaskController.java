package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/v1/tasks")
@AllArgsConstructor
public class TaskController {

    public final DbService service;
    public final TaskMapper taskMapper;
    @GetMapping
    public List<TaskDto> getTasks() {
        List<Task> tasks = service.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);
    }
    @GetMapping(value = "{taskId}")
    public TaskDto getTask(@PathVariable Long taskId) {
        return new TaskDto(1L,"Test title", "test content");
    }
    @DeleteMapping
    public void deleteTask(Long taskId) {

    }
    @PutMapping
    public TaskDto updateTask (TaskDto taskDto) {
        return new TaskDto(1L, "edited test title", "Test content");
    }
    @PostMapping(value = "/Post")
    public  void createTask (TaskDto taskDto) {

    }
}

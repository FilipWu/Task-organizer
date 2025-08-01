package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskMapperTest {

    private final TaskMapper taskMapper = new TaskMapper();

    @Test
    void mapToTask() {
        TaskDto dto = new TaskDto(1L, "Test title", "Test content");

        Task task = taskMapper.mapToTask(dto);

        assertEquals(1L, task.getId());
        assertEquals("Test title", task.getTitle());
        assertEquals("Test content", task.getContent());
    }

    @Test
    void mapToTaskDto() {
        Task task = new Task(1L, "Test title", "Test content");

        TaskDto dto = taskMapper.mapToTaskDto(task);

        assertEquals(1L, dto.getId());
        assertEquals("Test title", dto.getTitle());
        assertEquals("Test content", dto.getContent());
    }

    @Test
    void mapToTaskDtoList() {
        List<Task> taskList = List.of(new Task(2L, "Another title", "Another content"),
                new Task(1L, "title", "content"));

        List<TaskDto> result = taskMapper.mapToTaskDtoList(taskList);

        assertEquals(2, result.size());
        assertEquals("Another title", result.get(0).getTitle());
        assertEquals("Another content", result.get(0).getContent());

    }
}
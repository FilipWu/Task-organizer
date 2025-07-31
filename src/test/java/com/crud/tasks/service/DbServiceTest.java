package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DbServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private DbService dbService;

    @Test
    void getAllTasks() {
        List<Task> tasks = List.of(new Task(1L,"Test task","test task"),
                new Task(2L,"task 2", "test task 2"));
        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = dbService.getAllTasks();

        assertEquals(2 , result.size());
        assertEquals("test task 2", result.get(1).getContent());
    }

    @Test
    void getTask() throws TaskNotFoundException {

        Task task = new Task(1L,"task", "test");
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Task result = dbService.getTask(1L);

        assertEquals(1L, result.getId());
        assertEquals("task", result.getTitle());
    }

    @Test
    void saveTask() {
        Task task = new Task(1L,"task test", "content");
        when(taskRepository.save(task)).thenReturn(task);

        Task result = dbService.saveTask(task);

        assertEquals("task test", result.getTitle());

    }

    @Test
    void deleteTask() throws TaskNotFoundException{
        Task task = new Task(1L,"task", "test");
        long idNumber = task.getId();
        when(taskRepository.existsById(idNumber)).thenReturn(true);

        dbService.deleteTask(idNumber);

        verify(taskRepository,times(1)).deleteById(idNumber);
    }
}
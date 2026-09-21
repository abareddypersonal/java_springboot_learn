package com.atchi.learningspringboot.controller;

import com.atchi.learningspringboot.dto.TaskRequestDto;
import com.atchi.learningspringboot.dto.TaskResponseDto;
import com.atchi.learningspringboot.model.Task;
import com.atchi.learningspringboot.service.TaskNewService;
import com.atchi.learningspringboot.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskNewService service;

    public TaskController(TaskNewService service) {
        this.service = service;
    }

    @GetMapping("/gettasks")
    public List<Task> getTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getByTaskId(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    @PostMapping("/createtask")
    public TaskResponseDto createTask(@Valid @RequestBody TaskRequestDto task) {
        return service.createTask(task);
    }

    @PutMapping("update/{id}")
    public TaskResponseDto updateTask(@PathVariable int id,@Valid @RequestBody TaskRequestDto task) {
        return service.updateTask(id, task);
    }

    @DeleteMapping("delete/{id}")
    public String deleteTask(@PathVariable long id) {
        service.deleteTask(id);
        return "Task Deleted";
    }
}

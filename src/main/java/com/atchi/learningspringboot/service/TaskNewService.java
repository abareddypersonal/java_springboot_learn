package com.atchi.learningspringboot.service;

import com.atchi.learningspringboot.dto.TaskRequestDto;
import com.atchi.learningspringboot.dto.TaskResponseDto;
import com.atchi.learningspringboot.exception.ResourceNotFoundException;
import com.atchi.learningspringboot.model.Task;
import com.atchi.learningspringboot.model.User;
import com.atchi.learningspringboot.repository.TaskNewRepository;
import com.atchi.learningspringboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskNewService {

    private final TaskNewRepository repository;
    private final UserRepository userRepository;

    public TaskNewService(TaskNewRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public TaskResponseDto createTask(TaskRequestDto request) {

        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setCompleted(request.getCompleted());
        task.setUser(user);

        Task savedTask = repository.save(task);

        TaskResponseDto response = new TaskResponseDto();

        response.setId(savedTask.getId());
        response.setTitle(savedTask.getTitle());
        response.setCompleted(savedTask.isCompleted());
        response.setUserId(savedTask.getUser().getId());

        return response;


    }

    public Task getTaskById(Long id) {
        return repository.getReferenceById(id);
    }

    public TaskResponseDto updateTask(long id, TaskRequestDto request) {

        Task existingTask = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task not found with id : "+ id));
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        existingTask.setTitle(request.getTitle());
        existingTask.setCompleted(request.getCompleted());
        existingTask.setUser(user);

        Task updateTask = repository.save(existingTask);

        TaskResponseDto response = new TaskResponseDto();

        response.setId(updateTask.getId());
        response.setTitle(updateTask.getTitle());
        response.setCompleted(updateTask.isCompleted());
        response.setUserId(updateTask.getUser().getId());

        return response;


    }

    public void deleteTask(long id) {
        Task existingTask = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        repository.delete(existingTask);
    }
}

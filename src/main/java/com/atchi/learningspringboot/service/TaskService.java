package com.atchi.learningspringboot.service;

import com.atchi.learningspringboot.model.Task;
import com.atchi.learningspringboot.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTask() {
        return repository.findAll();
    }

    public Task getTaskById(int id) {
        return repository.findById(id);
    }
    public Task createTask(Task task){
        return repository.saveTask(task);
    }

    public Task updateTask(int id, Task task){
        return repository.updateTask(id,task);
    }
    public boolean delete(int id){
        return  repository.deleteTask(id);
    }
}

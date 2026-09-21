package com.atchi.learningspringboot.repository;

import com.atchi.learningspringboot.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();

    public TaskRepository() {
        tasks.add(new Task("Learn Java", false));
        tasks.add(new Task("Learn Spring", false));
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
    public Task saveTask(Task task){
        tasks.add(task);
        return task;
    }

    public Task updateTask(int id, Task updateTask){
        for (Task task : tasks){
            if(task.getId()==id){
                task.setTitle(updateTask.getTitle());
                task.setCompleted(updateTask.isCompleted());

                return task;
            }
        }

        return null;
    }
    public boolean  deleteTask (int id){
        for(Task task: tasks){
            if(task.getId()==id){
                tasks.remove(task);
                return true;
            }
        }
        return  false;
    }
}

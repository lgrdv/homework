package ru.gordeeva.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gordeeva.models.Task;
import ru.gordeeva.repository.TasksRepository;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TasksRepository tasksRepository;

    public TaskController(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @GetMapping("/get/{id}")
    public Task getTaskById(@PathVariable int id){
        Task task = tasksRepository.findById(id);
        System.out.println(task.toString());
    return task;

    }

    @PostMapping("/create")
    public void createTask(@RequestBody Task task){
        tasksRepository.save(task);
    }

    @PostMapping("/edit")
    public void editTask(@RequestBody Task task){
        System.out.println(UUID.randomUUID().toString());
        tasksRepository.save(task);


    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable int id){
        tasksRepository.deleteById(id);
    }

}

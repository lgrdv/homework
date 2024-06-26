package ru.gordeeva.controllers;

import org.springframework.web.bind.annotation.*;
import ru.gordeeva.models.Task;
import ru.gordeeva.repository.TasksRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TasksRepository tasksRepository;

    public TaskController(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @GetMapping("/get/{id}")
    public Task getTaskById(@PathVariable int id) {
        Task task = tasksRepository.findById(id);
        return task;
    }

    @PostMapping("/create")
    public void createTask(@RequestBody Task task) {
        tasksRepository.save(task);
    }

    @PostMapping("/edit")
    public void editTask(@RequestBody Task task) {
        tasksRepository.save(task);
    }

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return tasksRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable int id) {
        tasksRepository.deleteById(id);
    }

}

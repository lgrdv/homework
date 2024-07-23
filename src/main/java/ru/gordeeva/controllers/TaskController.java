package ru.gordeeva.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gordeeva.models.Response;
import ru.gordeeva.models.Task;
import ru.gordeeva.models.TaskDTO;
import ru.gordeeva.repository.TasksRepository;

import javax.swing.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TasksRepository tasksRepository;

    public TaskController(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @GetMapping("/getById/{id}")
    public Task getTaskById(@PathVariable int id) {
        return tasksRepository.findById(id);
    }

    @PostMapping("/create")
    public void createTask(@RequestBody TaskDTO taskDTO) {
        Task task = new Task();
        LocalDateTime dateTime = convertToLocalDate(taskDTO.getDateTime());
        task.setDateTime(dateTime);
        task.setDescription(taskDTO.getDescription());
        task.setStatus(false);
        tasksRepository.save(task);
    }

    @PostMapping("/getByDescription")
    public Task findByDescription(@RequestBody Task task) {
        String description = task.getDescription();
        return tasksRepository.findAllByDescriptionContainsIgnoreCase(description);
    }

    @PostMapping("/edit")
    public Response editTask(@RequestBody Task task) {
        if (!task.isStatus()) {
            tasksRepository.save(task);
        } else {
            return new Response(true, "Задача выполнена. Данные не редактируемы");
        }
        return new Response(false, "Данные успешно отредактированы");
    }

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return tasksRepository.findAll();
    }

    @Transactional
    @PostMapping("/delete")
    public void deleteTask(@RequestBody Task task) {
        tasksRepository.deleteById(task.getId());
    }

    private LocalDateTime convertToLocalDate(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return LocalDateTime.parse(dateTime, formatter);
    }

}

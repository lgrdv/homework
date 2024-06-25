package ru.gordeeva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gordeeva.models.Task;

import java.util.List;

public interface TasksRepository extends JpaRepository<Task, String> {
    List<Task> findAllByDescriptionContainsIgnoreCase(String keyword);
    Task findAllById(int id);
    Task deleteById(int id);

    Task findById(int id);
}

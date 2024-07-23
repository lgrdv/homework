package ru.gordeeva.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.gordeeva.models.Task;

import java.util.List;

public interface TasksRepository extends JpaRepository<Task, String> {
    Task findById(int id);
    Task findAllByDescriptionContainsIgnoreCase(String task);
    List<Task> findAll();

    void deleteById(int id);
}

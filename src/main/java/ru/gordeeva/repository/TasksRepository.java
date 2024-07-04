package ru.gordeeva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gordeeva.models.Task;

public interface TasksRepository extends JpaRepository<Task, String> {
    Task findById(int id);
}

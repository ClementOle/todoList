package com.olewski.todo.repository;

import com.olewski.todo.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Integer, Task> {
}

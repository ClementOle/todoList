package com.olewski.todo.repository;

import com.olewski.todo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Integer, User> {
}

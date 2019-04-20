package com.olewski.todo.controller;

import com.olewski.todo.model.Task;
import com.olewski.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	TaskRepository taskRepository;

	@GetMapping
	public Iterable<Task> getAll() {
		return taskRepository.findAll();
	}

	@PostMapping
	public Task post(@Valid @RequestBody Task task) {
		return taskRepository.save(task);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		taskRepository.delete(taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No task have this Id :" + id)));
	}
}

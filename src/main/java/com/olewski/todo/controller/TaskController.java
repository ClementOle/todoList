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

	@GetMapping("{id}")
	public Task getById(@PathVariable int id) {
		return taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No task have this id : " + id));
	}

	@PostMapping
	public Task post(@Valid @RequestBody Task task) {
		return taskRepository.save(task);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		taskRepository.delete(taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No task have this Id : " + id)));
	}

	@PutMapping
	public Task put(@Valid @RequestBody Task task) {
		Task taskTrouver = taskRepository.findById(task.getId()).orElseThrow(() -> new EntityNotFoundException("No task found with this Id : " + task.getId()));
		taskTrouver.setText(task.getText());
		taskTrouver.setIsDone(task.getIsDone());
		return taskRepository.save(taskTrouver);
	}
}

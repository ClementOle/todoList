package com.olewski.todo.models;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Task {
	@Id
	private Integer id;

	private String text;

	private Boolean isDone;
}

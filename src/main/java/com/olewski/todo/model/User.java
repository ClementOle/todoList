package com.olewski.todo.model;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class Utilisateur {
	@Id
	private Integer id;

	private String name;

	@OneToMany
	private List<Task> taskList;
}

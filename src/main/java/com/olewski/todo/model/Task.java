package com.olewski.todo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String text;

	private Boolean isDone;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Task)) return false;
		Task task = (Task) o;
		return Objects.equals(id, task.id) &&
				Objects.equals(text, task.text) &&
				Objects.equals(isDone, task.isDone);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, text, isDone);
	}

	@Override
	public String toString() {
		return "Task{" +
				"id=" + id +
				", text='" + text + '\'' +
				", isDone=" + isDone +
				'}';
	}
}

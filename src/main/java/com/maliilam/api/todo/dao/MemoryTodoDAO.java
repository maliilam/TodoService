package com.maliilam.api.todo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.maliilam.api.todo.model.Todo;

import org.springframework.stereotype.Component;

@Component
public class MemoryTodoDAO implements TodoDAO {
    private List<Todo> todos = new ArrayList<Todo>();
    private Integer maxId = 0;
    public List<Todo> findAll() {
        return todos;
    }
    public Optional<Todo> findById(Integer id) {
        return todos.stream().filter(todo -> todo.id.equals(id)).findFirst();
    }
    public Todo save(Todo todo) {
        if (todo.id == null) {
            todo.id = maxId++;
            this.todos.add(todo);
            return todo;    
        } else {
            return update(todo).orElse(null);
        }
    }
    private Optional<Todo> update(Todo todoUpdate) {
        Optional<Todo> foundTodo = todos.stream()
            .filter(todo -> todo.id.equals(todoUpdate.id))
            .findFirst();
        foundTodo.ifPresent(todo -> {
            todo.title = todoUpdate.title;
            todo.completed = todoUpdate.completed;
        });
        return foundTodo;
    }
    public void delete(Todo todo) {
        Optional<Todo> foundTodo = todos.stream().filter(td -> td.id.equals(todo.id)).findFirst();
        foundTodo.ifPresent( td -> todos.removeIf(t -> t.id.equals(td.id)));       
    }
}
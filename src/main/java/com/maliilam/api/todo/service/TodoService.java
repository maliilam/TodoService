package com.maliilam.api.todo.service;

import java.util.List;
import java.util.Optional;

import com.maliilam.api.todo.dao.TodoDAO;
import com.maliilam.api.todo.model.Todo;

import org.springframework.stereotype.Component;

@Component
public class TodoService {

    private TodoDAO todoDAO;
    public TodoService(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    public List<Todo> getTodos() {
        return todoDAO.findAll();
    }
    public Optional<Todo> getTodo(Integer id) {
        return todoDAO.findById(id);
    }
    public Optional<Todo> addTodo(Todo todo) {
        todo.id = null;
        return Optional.ofNullable(todoDAO.save(todo));
    }
    public Optional<Todo> updateTodo(Todo todo) {
        return todo.id == null ? Optional.empty() : Optional.ofNullable(todoDAO.save(todo));
    }
    public void deleteTodo(Integer id) {
        Todo todo = new Todo();
        todo.id = id;
        this.todoDAO.delete(todo);
    }

}
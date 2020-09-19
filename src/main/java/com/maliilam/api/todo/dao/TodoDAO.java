package com.maliilam.api.todo.dao;

import java.util.List;
import java.util.Optional;

import com.maliilam.api.todo.model.Todo;

public interface TodoDAO {
    public List<Todo> findAll();
    public Optional<Todo> findById(Integer id);
    public Todo save(Todo todo);
    public void delete(Todo todo);
}
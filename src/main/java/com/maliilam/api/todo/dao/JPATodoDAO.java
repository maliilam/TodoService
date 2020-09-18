package com.maliilam.api.todo.dao;

import com.maliilam.api.todo.model.Todo;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface JPATodoDAO extends JpaRepository<Todo, Integer>, TodoDAO {
}

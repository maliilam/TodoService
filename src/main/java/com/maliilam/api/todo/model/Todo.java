package com.maliilam.api.todo.model;

import java.util.Map;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String title;
    public boolean completed;
    
    public Todo() {}

    public Todo(Map<String, Object> todoMap) {
        id = (Integer) todoMap.get("id");
        title = (String) todoMap.get("title");
        completed = (Boolean) todoMap.get("completed");
    }
}
package com.learning.myFirstWebApp.todo.repository;

import com.learning.myFirstWebApp.todo.business.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    public List<Todo> findByUsername(String username);
}

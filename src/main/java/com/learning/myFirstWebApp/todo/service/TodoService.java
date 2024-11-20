package com.learning.myFirstWebApp.todo.service;

import com.learning.myFirstWebApp.todo.business.Todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todoCount = 0;

    static {
        todos.add(new Todo(++todoCount, "KB","Get AWS Certified1",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "KB","Get Spring Certified1",
                LocalDate.now().plusWeeks(2), false));
        todos.add(new Todo(++todoCount, "in28minutes","Get Springboot Certified1",
                LocalDate.now().plusMonths(3), false));
        todos.add(new Todo(++todoCount, "wits","Get COMS Certified1",
                LocalDate.now().plusWeeks(4), false));
        todos.add(new Todo(++todoCount, "wits","Get MATHS Certified1",
                LocalDate.now().plusYears(5), false));
    }

    @RequestMapping("list-todos")
    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate = todo -> todo.getUsername()
                .equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todoCount, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(long id){
        Predicate <? super Todo> predicate =
                todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(long id) {
        Predicate <? super Todo> predicate =
                todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}

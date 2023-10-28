package edu.whu.demo.controller;

import edu.whu.demo.entity.TodoItem;
import edu.whu.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todos")
public class TodoController {
    @Autowired
    TodoService todoService;

    // get:localhost:8080/todos/1
    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getTodo(@PathVariable long id){
        TodoItem result = todoService.getTodo(id);
        if(result == null){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(result);
        }
    }

    //get:localhost:8080/todos
    //get:localhost:8080/todos?name=作业
    //get:localhost:8080/todos?name=作业&&complete=true
    @GetMapping("")
    public ResponseEntity<List<TodoItem>> findTodos(String name, Boolean complete){
        List<TodoItem> result = todoService.findTodos(name, complete);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<TodoItem> addTodo(@RequestBody TodoItem todo){
        TodoItem result = todoService.addTodo(todo);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTodo(@PathVariable long id, @RequestBody TodoItem todo){
        todoService.updateTodo(id, todo);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable long id){
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }
}

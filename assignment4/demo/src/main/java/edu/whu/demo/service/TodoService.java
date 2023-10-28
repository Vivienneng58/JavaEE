package edu.whu.demo.service;

import edu.whu.demo.entity.TodoItem;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {
    //创建线程安全的map，模拟todo信息的存储
    private Map<Long, TodoItem> todos = Collections.synchronizedMap(new HashMap<Long, TodoItem>());

    public TodoItem addTodo(TodoItem todo){
        todos.put(todo.getId(), todo);
        return todo;
    }

    public TodoItem getTodo(long id){
        return todos.get(id);
    }

    public List<TodoItem> findTodos(String name, Boolean complete){
        List<TodoItem> result = new ArrayList<>();
        for(TodoItem todo: todos.values()){
            if(name != null && !todo.getName().contains(name)) continue;
            if(complete != null && !complete.equals(todo.isComplete())) continue;
            result.add(todo);
        }
        return result;
    }

    public void updateTodo(long id, TodoItem todo){
        TodoItem todo2 = todos.get(id);
        todo2.setName(todo.getName());
        todo2.setComplete(todo.isComplete());
        todos.put(id, todo2);
    }

    public void deleteTodo(long id){
        todos.remove(id);
    }
}

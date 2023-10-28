package edu.whu.demo.entity;

import lombok.Data;

@Data
public class TodoItem {
    long id;
    String name;
    boolean complete;
}

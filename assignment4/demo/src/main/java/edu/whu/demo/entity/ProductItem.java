package edu.whu.demo.entity;

import lombok.Data;

@Data
public class ProductItem {
    private long id;
    private String name;
    private double price;
    private int quantity;
}

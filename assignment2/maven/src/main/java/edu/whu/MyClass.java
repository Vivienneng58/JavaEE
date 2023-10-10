package edu.whu;
import org.example.InitMethod;

public class MyClass {
    @InitMethod
    public void init() {
        System.out.println("Initialization method is called.");
    }
}

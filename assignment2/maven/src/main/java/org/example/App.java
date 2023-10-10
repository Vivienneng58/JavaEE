package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        try {
            // 读取属性文件
            Properties properties = new Properties();
            InputStream inputStream = App.class.getClassLoader().getResourceAsStream("myapp.properties");
            properties.load(inputStream);

            // 获取配置的类名
            String className = properties.getProperty("bootstrapClass");

            // 根据类名创建对象
            Class<?> clazz = Class.forName(className);
            Object obj = clazz.getDeclaredConstructor().newInstance();

            // 调用带有 @InitMethod 注解的方法
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(InitMethod.class)) {
                    method.invoke(obj);
                }
            }
        } catch (IOException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

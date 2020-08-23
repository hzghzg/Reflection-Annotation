package com.huangda7.reflectionandannotation.myAnnotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestController
public class TestController {
    @Autowired
    Environment environment;

    @GetMapping("/test")
    public String dynamicCreateClass() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
//        System.out.println(environment.getProperty("classname"));
        Class className = Class.forName(environment.getProperty("className"));
        Object instance = className.newInstance();
        Method methodName = className.getDeclaredMethod(environment.getProperty("methodName"));
        methodName.invoke(instance);
        System.out.println("create class over!\r\nclassName:" + className.getName() + ";\r\nmethodName:" + methodName.getName());
        return "create class over!";
    }
}

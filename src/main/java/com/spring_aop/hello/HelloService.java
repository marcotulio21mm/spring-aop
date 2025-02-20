package com.spring_aop.hello;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public void hello(){
        System.out.println("hello");
    }
}

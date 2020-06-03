package com.apple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HelloWorldMainApplication {
    public static void main(String[] args) {
//        启动应用
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}



//加上注解 @SpringBootApplication标注一个主程序 说明这是一个spring boot应用
//psvm 是main方法的快捷键

//第一步写 HelloWorldMainApplication ，启动应用
//第二步写 crontroller类
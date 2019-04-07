package ru.springboot.ripper.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Example0Application {
    public static void main(String[] args) {
        ExampleProblemService bean = SpringApplication.run(Example0Application.class, args).getBean(ExampleProblemService.class);

        bean.doProblem();
    }
}

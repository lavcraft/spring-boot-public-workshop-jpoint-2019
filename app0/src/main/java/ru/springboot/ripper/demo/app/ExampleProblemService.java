package ru.springboot.ripper.demo.app;

import org.springframework.stereotype.Repository;

@Repository
public class ExampleProblemService {
    public void doProblem() {
        throw new RuntimeException("Db is down!");
    }
}

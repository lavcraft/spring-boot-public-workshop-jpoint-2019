package ru.springboot.ripper.demo.app.withexception;

import org.springframework.stereotype.Service;

public class ProblemService {
    public void problem() {
        throw new RuntimeException();
    }
}

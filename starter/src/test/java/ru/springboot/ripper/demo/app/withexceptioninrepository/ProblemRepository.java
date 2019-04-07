package ru.springboot.ripper.demo.app.withexceptioninrepository;

import org.springframework.stereotype.Repository;

@Repository
public class ProblemRepository {
    public void problem() {
        throw new RuntimeException();
    }
}

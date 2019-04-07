package ru.springboot.ripper.demo.app.withexception;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.springboot.ripper.demo.starter.SendEmailService;

import static org.mockito.Mockito.verify;

@SpringJUnitConfig
@SpringBootTest
public class WithExApplicationTest {
    @MockBean  SendEmailService sendEmailService;
    @Autowired ProblemService   problemService;

    @Test
    void should_print_when_exception() {
        //when
        try {
            problemService.problem();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //then
        verify(sendEmailService).sendNotification();
    }

    @SpringBootApplication
    @EnableAspectJAutoProxy
    public static class AppWithThrowingService {

        @Bean
        public ProblemService problemService() {
            return new ProblemService();
        }

    }

}

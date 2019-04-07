package ru.springboot.ripper.demo.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
public class DemoAutoConfiguration {

    @Bean
    public DbExceptionHandler dbExceptionHandler() {
        return new DbExceptionHandler(sendEmailService());
    }

    @Bean
    public SendEmailService sendEmailService() {
        return new SendEmailService();
    }
}

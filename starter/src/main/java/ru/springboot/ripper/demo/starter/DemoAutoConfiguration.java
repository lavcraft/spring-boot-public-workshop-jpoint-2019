package ru.springboot.ripper.demo.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DemoProperties.class)
public class DemoAutoConfiguration {

    @Bean
    @ConditionalOnProperty("demo.dba-emails")
    public DbExceptionHandler dbExceptionHandler(SendEmailService sendEmailService) {
        return new DbExceptionHandler(sendEmailService);
    }

    @Bean
    public SendEmailService sendEmailService(DemoProperties properties) {
        return new SendEmailService(properties);
    }
}

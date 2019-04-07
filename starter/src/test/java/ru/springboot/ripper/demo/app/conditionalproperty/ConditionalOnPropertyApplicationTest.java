package ru.springboot.ripper.demo.app.conditionalproperty;


import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.annotation.UserConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import ru.springboot.ripper.demo.starter.DbExceptionHandler;
import ru.springboot.ripper.demo.starter.DemoAutoConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

public class ConditionalOnPropertyApplicationTest {
    ApplicationContextRunner runner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(DemoAutoConfiguration.class))
            .withConfiguration(UserConfigurations.of(App.class));

    @Test
    void should_create_exception_handler_when_set_email_property() {
        //when
        runner.withPropertyValues("demo.dba-emails=test@email.email")
                .run(context -> org.junit.jupiter.api.Assertions.assertAll(
                () -> assertThat(context).hasSingleBean(DbExceptionHandler.class))
        );

    }

    @Test
    void should_not_create_exception_handler_when_thereis_no_email_property() {
        //when
        runner
                .run(context -> org.junit.jupiter.api.Assertions.assertAll(
                        () -> assertThat(context).doesNotHaveBean(DbExceptionHandler.class))
                );
    }

    @SpringBootApplication
    public static class App {

    }
}


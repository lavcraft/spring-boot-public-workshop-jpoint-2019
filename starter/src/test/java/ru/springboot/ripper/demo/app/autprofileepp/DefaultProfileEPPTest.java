package ru.springboot.ripper.demo.app.autprofileepp;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.annotation.UserConfigurations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.springboot.ripper.demo.starter.DbExceptionHandler;
import ru.springboot.ripper.demo.starter.DemoAutoConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig
@SpringBootTest(classes = DefaultProfileEPPTest.App.class)
public class DefaultProfileEPPTest {
    @Autowired Environment environment;

    @Test
    void should_set_default_profile() {
        //expect
        assertThat(environment.getActiveProfiles()).contains("myprofile");
    }


    @SpringBootApplication
    public static class App {

    }
}


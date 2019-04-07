package ru.springboot.ripper.demo.app.autprofileepp;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig
@SpringBootTest(classes = CustomProfileEPPTest.App.class)
@ActiveProfiles("customprofile")
public class CustomProfileEPPTest {
    @Autowired Environment environment;

    @Test
    void should_not_set_default_profile() {
        //expect
        assertThat(environment.getActiveProfiles()).doesNotContain("myprofile");
    }


    @SpringBootApplication
    public static class App {

    }
}


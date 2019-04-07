package ru.springboot.ripper.demo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class AutoProfileEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if(environment.getActiveProfiles().length == 0) {
            environment.setActiveProfiles("myprofile");
        }
    }
}

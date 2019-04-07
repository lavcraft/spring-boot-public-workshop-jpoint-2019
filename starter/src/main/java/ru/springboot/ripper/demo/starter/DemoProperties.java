package ru.springboot.ripper.demo.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {
    private List<String> dbaEmails;
}

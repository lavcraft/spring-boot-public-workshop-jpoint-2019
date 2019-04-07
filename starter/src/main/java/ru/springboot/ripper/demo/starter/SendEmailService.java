package ru.springboot.ripper.demo.starter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SendEmailService {
    private final DemoProperties demoProperties;

    public void sendNotification() {
        demoProperties.getDbaEmails().forEach(s -> {
            log.info("Sending email to {} ...", s);
        });
    }

}

package ru.springboot.ripper.demo.starter;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
@RequiredArgsConstructor
public class DbExceptionHandler {
    private final SendEmailService sendEmailService;

    @AfterThrowing(pointcut = "execution(* ru.springboot.ripper.demo.app..*.*(..))", throwing = "ex")
    public void afterThrow(RuntimeException ex) {
        System.out.println("Throw exception`" + ex);
        sendEmailService.sendNotification();
    }
}

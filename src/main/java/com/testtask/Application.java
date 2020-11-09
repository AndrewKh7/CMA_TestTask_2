package com.testtask;

import com.testtask.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;



public class Application {

    public static void main(String... args) throws ParseException {
        System.out.println("Starting...");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        context.getBean(ConsoleMenu.class).run();
    }

}

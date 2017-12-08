package me.robbie.boot.test;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@ImportResource("classpath:META-INF/spring/context.xml")
public class Run {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Run.class, args);
    }
}
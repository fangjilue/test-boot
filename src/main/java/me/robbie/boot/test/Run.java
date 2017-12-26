package me.robbie.boot.test;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @SpringBootApplication 集成了
 * @SpringBootConfiguration 等价于Configuration
 * @EnableAutoConfiguration
 * @ComponentScan
 */
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
@ImportResource("classpath:META-INF/spring/context.xml")
public class Run {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Run.class, args);

        ApplicationArguments applicationArguments = context.getBean(ApplicationArguments.class);
        System.out.println("============Run main===========");
        for(String name : applicationArguments.getOptionNames()){
            System.out.println("name=" + name + ",value="+applicationArguments.getOptionValues(name));
        }
    }
}
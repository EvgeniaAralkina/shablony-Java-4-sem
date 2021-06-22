package org.example;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Test implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Test.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(BeanConfig.class);
        MyApplication app = (MyApplication) context.getBean("app");
    }
}

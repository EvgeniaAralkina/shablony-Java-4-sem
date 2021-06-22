package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@PropertySource("classpath:application.yml")
@Component
public class Student {

    @Value("${program.student.name}")
    private String name;

    @Value("${program.student.last_name}")
    private String last_name;

    @Value("${program.student.group}")
    private String group;

    @PostConstruct
    public void init() {
        System.out.println(name + " " + last_name + " " + group);
    }

}

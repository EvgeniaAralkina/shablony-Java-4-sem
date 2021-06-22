package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean("app")
    public MyApplication app1() {
        return new MyApplication("file2.txt");//, "file2.txt");
    }
}


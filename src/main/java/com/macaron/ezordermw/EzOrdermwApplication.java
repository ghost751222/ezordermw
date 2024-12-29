package com.macaron.ezordermw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:persistence.properties"})
public class EzOrdermwApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.out.println("test");
        SpringApplication.run(EzOrdermwApplication.class, args);
    }

}

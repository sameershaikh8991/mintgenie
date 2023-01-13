package com.mintgenie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MintgenieApplication {

    public static void main(String[] args) {
        SpringApplication.run(MintgenieApplication.class, args);
        System.err.println("READY TO TEST...!");

    }

}

package com.dance_scacpe_explorer.rythmcoders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RythmCodersApplication {

    public static void main(String[] args) {
        SpringApplication.run(RythmCodersApplication.class, args);
    }

}

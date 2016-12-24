package com.rish889;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ECheckMobileRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECheckMobileRestApiApplication.class, args);
    }

    @RequestMapping("/")
    public String getRaces() {
        return "Rishabh";
    }
}

package com.rish889;

import hello.Customer;
import hello.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaRepositories("hello")
@EntityScan("hello")
@RestController

public class ECheckMobileRestApiApplication {

    private static final Logger log = LoggerFactory.getLogger(ECheckMobileRestApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ECheckMobileRestApiApplication.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");
        };
    }

    @Bean
    @RequestMapping("/")
    public String getRaces(CustomerRepository repository) {
        return repository.findAll().toString();
    }

}
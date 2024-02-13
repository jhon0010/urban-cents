package com.urban.cents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello user service !!");
        SpringApplication.run(Main.class, args);
    }
}

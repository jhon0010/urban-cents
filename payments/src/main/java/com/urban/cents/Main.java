package com.urban.cents;

import common.com.urban.cent.UrbanStringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Main {

        public static void main(String[] args) {

            System.out.println("Hello PaymentsApplication!!" +
                    UrbanStringUtils.reverse("You can access the commons library from here!"));
            SpringApplication.run(Main.class, args);
        }

}

package com.urban.cents;

import common.com.urban.cent.UrbanStringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class Main {

        public static void main(String[] args) {

            System.out.println("Hello PaymentsApplication!!");
            System.out.println("Hello PaymentsApplication!!" + UrbanStringUtils.reverse("Hello PaymentsApplication!!"));
            SpringApplication.run(Main.class, args);
        }

}

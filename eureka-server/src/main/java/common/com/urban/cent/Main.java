package common.com.urban.cent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalancerAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude = {LoadBalancerAutoConfiguration.class})
@EnableEurekaServer
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World from eureka server!");
        SpringApplication.run(Main.class, args);
    }

}

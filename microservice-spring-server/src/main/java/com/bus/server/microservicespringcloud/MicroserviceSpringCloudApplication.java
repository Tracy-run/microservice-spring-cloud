package com.bus.server.microservicespringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceSpringCloudApplication {

    public static void main(String[] args){
        SpringApplication.run(MicroserviceSpringCloudApplication.class, args);
    }

}

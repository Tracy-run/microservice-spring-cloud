package com.bus.simple.user.microservicesimpleprovideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceSimpleProviderUserApplication {

    public static void main(String[] args){
        SpringApplication.run(MicroserviceSimpleProviderUserApplication.class, args);
    }

}

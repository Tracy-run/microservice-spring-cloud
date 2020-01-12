package com.bus.provider.user.microservicespringprovideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceSpringProviderUserApplication {

    public static void main(String[] args){
        SpringApplication.run(MicroserviceSpringProviderUserApplication.class, args);
    }

}

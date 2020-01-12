package com.bus.user.microservicespringuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
//@EnableDiscoveryClient   支持多种组件
@SpringBootApplication
public class MicroserviceSpringUserApplication {

    public static void main(String[] args){
        SpringApplication.run(MicroserviceSpringUserApplication.class, args);
    }

}

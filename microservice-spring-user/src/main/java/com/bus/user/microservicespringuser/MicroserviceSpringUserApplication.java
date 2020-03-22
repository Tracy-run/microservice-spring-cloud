package com.bus.user.microservicespringuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
//@EnableDiscoveryClient   支持多种组件
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class MicroserviceSpringUserApplication {

    public static void main(String[] args){
        SpringApplication.run(MicroserviceSpringUserApplication.class, args);
    }

}

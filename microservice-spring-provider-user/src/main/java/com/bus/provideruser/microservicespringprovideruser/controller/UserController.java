package com.bus.provideruser.microservicespringprovideruser.controller;

import com.bus.provideruser.microservicespringprovideruser.entity.User;
import com.bus.provideruser.microservicespringprovideruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @Resource
//    private EurekaDiscoveryClient eurekaDiscoveryClient;
//
//    public EurekaServiceInstance showInfo(){
//        List<EurekaServiceInstance> instance = this.eurekaDiscoveryClient.getInstances("microservice-spring-server");
//        return instance.get(0);
//    }


    @GetMapping(value = "/simple/{id}")
    public User findUserById(@PathVariable Integer id){
        return this.userRepository.findById(id).get();
    }

    @GetMapping(value = "/simple/all")
    public List<User> findUserId(){
        return this.userRepository.findAll();
    }

}

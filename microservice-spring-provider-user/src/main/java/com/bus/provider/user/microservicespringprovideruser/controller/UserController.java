package com.bus.provider.user.microservicespringprovideruser.controller;

import java.util.ArrayList;
import java.util.List;

import com.bus.provider.user.microservicespringprovideruser.entity.User;
import com.bus.provider.user.microservicespringprovideruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id) {
        return this.userRepository.findById(Integer.parseInt(id.toString())).get();
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user) {
        return user;
    }

    // 该请求不会成功
    @GetMapping("/get-user")
    public User getUser(User user) {
        return user;
    }

    @GetMapping("list-all")
    public List<User> listAll() {
        ArrayList<User> list = new ArrayList();
        User user = new User(1, "zhangsan");
        User user2 = new User(2, "zhangsan");
        User user3 = new User(3, "zhangsan");
        list.add(user);
        list.add(user2);
        list.add(user3);
        return list;

    }
}
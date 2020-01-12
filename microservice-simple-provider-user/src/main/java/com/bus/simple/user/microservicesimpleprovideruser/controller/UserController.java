package com.bus.simple.user.microservicesimpleprovideruser.controller;

import java.util.ArrayList;
import java.util.List;

import com.bus.simple.user.microservicesimpleprovideruser.entity.User;
import com.bus.simple.user.microservicesimpleprovideruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
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

//  @GetMapping("/simple/{id}")
//  public User findById(@PathVariable Long id) {
//    return this.userRepository.findOne(id).get();
//  }

  @GetMapping("/eureka-instance")
  public String serviceUrl() {
    InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
    return instance.getHomePageUrl();
  }

//  @GetMapping("/instance-info")
//  public ServiceInstance showInfo() {
//    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
//    return localServiceInstance;
//  }

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
    User user = new User(1L, "zhangsan");
    User user2 = new User(2L, "zhangsan");
    User user3 = new User(3L, "zhangsan");
    list.add(user);
    list.add(user2);
    list.add(user3);
    return list;

  }
}

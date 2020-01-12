package com.bus.provider.user.microservicespringprovideruser.repository;

import com.bus.provider.user.microservicespringprovideruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {



}

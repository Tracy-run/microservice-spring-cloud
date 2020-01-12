package com.bus.simple.user.microservicesimpleprovideruser.repository;

import com.bus.simple.user.microservicesimpleprovideruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

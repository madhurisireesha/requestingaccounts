package com.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entities.User;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {

	User findByUsername(String loginuser);

}

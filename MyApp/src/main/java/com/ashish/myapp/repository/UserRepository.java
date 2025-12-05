package com.ashish.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashish.myapp.entity.User;

public interface UserRepository  extends JpaRepository<User, Long> {

}

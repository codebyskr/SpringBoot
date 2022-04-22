package com.practice.dbconnectivity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.dbconnectivity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}

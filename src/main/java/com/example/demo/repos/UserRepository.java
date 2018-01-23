package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}




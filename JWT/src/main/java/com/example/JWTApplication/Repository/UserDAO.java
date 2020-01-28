package com.example.JWTApplication.Repository;

import com.example.JWTApplication.Entity.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<DAOUser,Integer> {
            DAOUser findByUsername(String userName);
}
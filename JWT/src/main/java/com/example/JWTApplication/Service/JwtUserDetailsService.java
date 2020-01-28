package com.example.JWTApplication.Service;

import com.example.JWTApplication.Entity.DAOUser;
import com.example.JWTApplication.Repository.UserDAO;
import com.example.JWTApplication.RequestDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName)
    throws UsernameNotFoundException {
        DAOUser user = userDAO.findByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                                                                      new ArrayList<>());
    }

    public DAOUser save(UserDTO userDTO){
        DAOUser user = new DAOUser();
        user.setUsername(userDTO.getUsername());
        user.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        return userDAO.save(user);
    }
}

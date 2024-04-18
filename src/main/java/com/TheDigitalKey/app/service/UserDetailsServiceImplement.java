package com.TheDigitalKey.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.TheDigitalKey.app.bd.User;
import com.TheDigitalKey.app.Repositorys.IUserRepository;

public class UserDetailsServiceImplement implements UserDetailsService {
 
    @Autowired
    private IUserRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new UserDetailsServices(user);
    }
 
}

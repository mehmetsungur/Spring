package com.modulcar.security.service;

import com.modulcar.domain.Role;
import java.util.*;
import com.modulcar.domain.User;
import com.modulcar.exception.ResourceNotFoundException;
import com.modulcar.exception.UsernameNotFoundException;
import com.modulcar.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username).orElseThrow(()->
                new ResourceNotFoundException("User not found with username: " + username));

        if(user != null){
            org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(user.getUserName(),
                    user.getPassword(),
                    user.getRoles());
            return user1;
        }
        return null;
    }

    private static List<SimpleGrantedAuthority> buildGrantedAuthorities(final Set<Role> roles){
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for(Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getName().name()));
        }

        return authorities;
    }
}

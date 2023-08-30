package com.modulcar.security.service;

import com.modulcar.exception.UsernameNotFoundException;

public interface UserDetailsService {
    org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException;
}

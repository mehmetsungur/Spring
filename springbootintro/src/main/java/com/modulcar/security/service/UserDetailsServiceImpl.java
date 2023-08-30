package com.modulcar.security.service;

import com.modulcar.exception.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}

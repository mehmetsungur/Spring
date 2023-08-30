package com.modulcar.security.service;

import com.modulcar.exception.UsernameNotFoundException;

public interface UserDetailsService {
    UserDetails loadUserByUSername(String username) throws UsernameNotFoundException;
}

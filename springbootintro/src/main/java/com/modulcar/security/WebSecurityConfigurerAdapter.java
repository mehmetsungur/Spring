package com.modulcar.security;

public abstract class WebSecurityConfigurerAdapter {
    protected abstract void configure(HttpSecurity http) throws Exception;

    protected abstract void configure(AuthenticationManagerBuilder auth, Object authProvider) throws Exception;

    protected abstract void configure(AuthenticationManagerBuilder auth) throws Exception;
}

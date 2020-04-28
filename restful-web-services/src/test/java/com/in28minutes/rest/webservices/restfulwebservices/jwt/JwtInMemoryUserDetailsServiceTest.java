package com.in28minutes.rest.webservices.restfulwebservices.jwt;


import org.junit.Test;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class JwtInMemoryUserDetailsServiceTest {


    @Test
    public void loadUserNameTest_success() {

        String username = "utkarsh";
        JwtInMemoryUserDetailsService jwtInMemoryUserDetailsService = new JwtInMemoryUserDetailsService();
        assertEquals("utkarsh", jwtInMemoryUserDetailsService.loadUserByUsername(username).getUsername());
        assertEquals("$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", jwtInMemoryUserDetailsService.loadUserByUsername(username).getPassword());

    }

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserNameTest_failure() {

        String username = "username";
        JwtInMemoryUserDetailsService jwtInMemoryUserDetailsService = new JwtInMemoryUserDetailsService();
        assertNotEquals("utkarsh", jwtInMemoryUserDetailsService.loadUserByUsername(username).getUsername());
        assertNotEquals("$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", jwtInMemoryUserDetailsService.loadUserByUsername(username).getPassword());

    }
}

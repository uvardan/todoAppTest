package com.in28minutes.rest.webservices.restfulwebservices.jwt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JwtTokenRequestTest {



    @Test
    public void t1(){
        JwtTokenRequest jwtTokenRequest= new JwtTokenRequest("abcd","dfgs");
        assertEquals(jwtTokenRequest.getUsername(),"abcd");
        assertEquals(jwtTokenRequest.getPassword(),"dfgs");
    }

    @Test
    public void t2(){

        JwtUserDetails jwtUserDetails =new JwtUserDetails(1L,"user", "pwd","ROLE2");

        assertEquals(jwtUserDetails.getUsername(),"user");
        assertEquals(jwtUserDetails.getPassword(),"pwd");
    }
}

package com.in28minutes.rest.webservices.restfulwebservices.jwt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class JwtTokenAuthorizationOncePerRequestFilterTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain mockFilterChain;

    @Mock
    private JwtTokenUtil mockJwtTokenUtil;


    @Autowired
    private JwtTokenAuthorizationOncePerRequestFilter authorizationOncePerRequestFilter;

    @Test
    public void t1(){

        try {
            when(request.getHeader(any())).thenReturn("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1dGthcnNoIiwiZXhwIjoxNTg4MzEwMDQ3LCJpYXQiOjE1ODc3MDUyNDd9.8RB_DJ_8b5mUOnxu5xYCCt1Yh9id1DbvcCWf83Pg3gt98U0DwOSHj3UxD8cPxM9MuQhpLGcth3nLvmiqH6e57w");
            when(mockJwtTokenUtil.getUsernameFromToken(any())).thenReturn("utkarsh");
            authorizationOncePerRequestFilter.doFilterInternal(request,response,mockFilterChain);
            verify(mockFilterChain,atLeast(1)).doFilter(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t2(){

        try {
            when(request.getHeader(any())).thenReturn(null);
            authorizationOncePerRequestFilter.doFilterInternal(request,response,mockFilterChain);
            verify(mockFilterChain,atLeast(1)).doFilter(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

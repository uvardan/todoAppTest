package com.in28minutes.rest.webservices.restfulwebservices.jwt;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.security.core.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class JwtUnAuthorizedResponseAuthenticationEntryPointTest {



    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    HttpServletResponse httpServletResponse;

    @InjectMocks
    AuthenticationException authenticationException = new AuthenticationException("Testing Commence method") {
        @Override
        public String getMessage() {
            return super.getMessage();
        }
    };

    @InjectMocks
    JwtUnAuthorizedResponseAuthenticationEntryPoint jwtUnAuthorizedResponseAuthenticationEntryPoint;

    @Test
    public void t1(){
        try {

            jwtUnAuthorizedResponseAuthenticationEntryPoint.commence(httpServletRequest, httpServletResponse, authenticationException);
            assertEquals(0,httpServletResponse.getStatus());
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}

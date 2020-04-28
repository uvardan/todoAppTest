package com.in28minutes.rest.basic.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthenticationBeanTest {




    @Test
    public void test1(){
        AuthenticationBean authenticationBeanMock= new AuthenticationBean("Hello");
        assertEquals(authenticationBeanMock.getMessage(),"Hello");
        authenticationBeanMock.setMessage("Message");
        assertEquals(authenticationBeanMock.getMessage(),"Message");
        assertEquals(authenticationBeanMock.toString(),"HelloWorldBean [message=Message]");
        System.out.println(authenticationBeanMock.toString());
    }
}

package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import com.in28minutes.rest.basic.auth.AuthenticationBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldBeanTest {


    @Test
    public void test1() {
        HelloWorldBean authenticationBeanMock = new HelloWorldBean("Hello");
        assertEquals(authenticationBeanMock.getMessage(), "Hello");
        authenticationBeanMock.setMessage("Message");
        assertEquals(authenticationBeanMock.getMessage(), "Message");
        assertEquals(authenticationBeanMock.toString(), "HelloWorldBean [message=Message]");
        System.out.println(authenticationBeanMock.toString());
    }

}

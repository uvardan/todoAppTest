package com.in28minutes.rest.basic.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class BasicAuthenticationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void accessProtected1() throws Exception {

        String json = "{ \"username\":\"utkarsh\",\"password\":\"dummy1\"}";
        try {
            this.mockMvc.perform(get("/basicauth").header("Origin", "http://localhost:4200").content(json).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isUnauthorized());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.in28minutes.rest.webservices.restfulwebservices.jwt;


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
public class TestController {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void accessProtected1() throws Exception {

        String json = "{ \"username\":\"utkarsh\",\"password\":\"dummy1\"}";
        try {
            this.mockMvc.perform(post("/authenticate").header("Origin", "http://localhost:4200").content(json).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isUnauthorized());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void accessProtected2() throws Exception {

        String json = "{ \"username\":\"utkarsh\",\"password\":\"dummy\"}";
        try {
            this.mockMvc.perform(post("/authenticate").header("Origin", "http://localhost:4200").content(json).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void accessProtected3() throws Exception {

        try {
            this.mockMvc.perform(get("/refresh").header("Origin", "http://localhost:4200").header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1dGthcnNoIiwiZXhwIjoxNTg4MzEzOTA3LCJpYXQiOjE1ODc3MDkxMDd9.zUsTODTAUBdyqasEfoMF8eFb_2ql9SlnThGRsMwby35BUODbr--jj5UjFhTDh-vBew_FWtohT1e3MrgENf4k9g"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void accessProtected4() throws Exception {

        try {
            this.mockMvc.perform(get("/refresh").header("Origin", "http://localhost:4200").header("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1dGthcnNoIiwiZXhwIjoxNTg4MzEzOTA3LCJpYXQiOjE1ODc3MDkxMDd9.zUsTODTAUBdyqasEfoMF8eFb_2ql9SlnThGRsMwby35BUODbr--jj5UjFhTDh-vBew_FWtohT1e3MrgENf4k9g"))
                    .andExpect(status().isUnauthorized());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void accessProtected5() throws Exception {

        try {
            this.mockMvc.perform(get("/refresh").header("Origin", "http://localhost:4200").header("Authorization", "null"))
                    .andExpect(status().isUnauthorized());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


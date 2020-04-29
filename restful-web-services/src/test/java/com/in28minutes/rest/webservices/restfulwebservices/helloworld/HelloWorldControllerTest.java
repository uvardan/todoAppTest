package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void HelloWorld() throws Exception {

        try {
            this.mockMvc.perform(get("/hello-world").header("Origin", "http://localhost:4200").header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1dGthcnNoIiwiZXhwIjoxNTg4MzEzOTA3LCJpYXQiOjE1ODc3MDkxMDd9.zUsTODTAUBdyqasEfoMF8eFb_2ql9SlnThGRsMwby35BUODbr--jj5UjFhTDh-vBew_FWtohT1e3MrgENf4k9g"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void HelloWorldBean() throws Exception {

        try {
            this.mockMvc.perform(get("/hello-world-bean").header("Origin", "http://localhost:4200").header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1dGthcnNoIiwiZXhwIjoxNTg4MzEzOTA3LCJpYXQiOjE1ODc3MDkxMDd9.zUsTODTAUBdyqasEfoMF8eFb_2ql9SlnThGRsMwby35BUODbr--jj5UjFhTDh-vBew_FWtohT1e3MrgENf4k9g"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void HelloWorldPathVariable() throws Exception {

        try {
            this.mockMvc.perform(get("/hello-world/path-variable/TestName").header("Origin", "http://localhost:4200").header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1dGthcnNoIiwiZXhwIjoxNTg4MzEzOTA3LCJpYXQiOjE1ODc3MDkxMDd9.zUsTODTAUBdyqasEfoMF8eFb_2ql9SlnThGRsMwby35BUODbr--jj5UjFhTDh-vBew_FWtohT1e3MrgENf4k9g"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

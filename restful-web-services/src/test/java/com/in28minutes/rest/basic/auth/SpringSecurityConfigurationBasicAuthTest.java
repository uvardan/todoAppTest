package com.in28minutes.rest.basic.auth;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)

public class SpringSecurityConfigurationBasicAuthTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void accessProtected() throws Exception {
        this.mockMvc.perform(get("/basicauth"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void loginUser() throws Exception {
        MvcResult result=this.mockMvc.perform(get("/basicauth").with(httpBasic("utkarsh","dummy")).header("Origin", "http://localhost:4200").contentType(MediaType.APPLICATION_JSON))
                .andExpect(authenticated())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    public void loginInvalidUser() throws Exception {
        MvcResult result = this.mockMvc.perform(formLogin().user("invalid").password("invalid"))
                .andExpect(unauthenticated())
                .andExpect(status().is4xxClientError())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString().contains(""));
    }


}


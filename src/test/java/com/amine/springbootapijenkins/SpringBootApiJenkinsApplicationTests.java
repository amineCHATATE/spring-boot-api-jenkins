package com.amine.springbootapijenkins;

import com.amine.springbootapijenkins.entity.Theme;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith( SpringExtension.class)
@AutoConfigureMockMvc
class SpringBootApiJenkinsApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void getsAllThemes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/theme")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @Order(2)
    public void getsSingleTheme() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/theme/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @Order(3)
    public void returnsNotFoundForInvalidSingleTheme() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/theme/50")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    @Order(4)
    public void addsNewTheme() throws Exception {
        String newTheme = "{\"name\":\"Monorail\",\"description\":\"Sedate travelling ride.\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/theme")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newTheme)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @Order(5)
    public void deleteTheme() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/theme/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }
}

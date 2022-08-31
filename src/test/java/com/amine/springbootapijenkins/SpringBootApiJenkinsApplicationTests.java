package com.amine.springbootapijenkins;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith( SpringExtension.class)
@AutoConfigureMockMvc
class SpringBootApiJenkinsApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getsAllThemes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/theme")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getsSingleTheme() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/theme/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void returnsNotFoundForInvalidSingleTheme() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/theme/50")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
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
    public void deleteTheme() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/theme/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}

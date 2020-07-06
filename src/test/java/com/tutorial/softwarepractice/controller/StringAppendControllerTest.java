package com.tutorial.softwarepractice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.softwarepractice.model.Info;
import com.tutorial.softwarepractice.service.StringAppendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(StringAppendController.class)
public class StringAppendControllerTest {

    private MockMvc mockMvc;

    @Autowired
    public StringAppendControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void given_a_valid_keyword_should_get_the_response_with_the_predefined_appended_string() throws Exception {

        String uri = "/append";
        String jsonRequest = mapToJson(new Info("Java"));
        MvcResult mvcResult = getResultFromEndpoint(uri, jsonRequest);
        assertEquals(201, mvcResult.getResponse().getStatus());

        String content = mvcResult.getResponse().getContentAsString();
        assertEquals("Java is cool", content);
    }

    @Test
    public void given_an_invalid_keyword_should_get_a_bad_request_response() throws Exception {

        String uri = "/append";
        String jsonRequest = mapToJson(new Info(""));
        MvcResult mvcResult = getResultFromEndpoint(uri, jsonRequest);
        assertEquals(400, mvcResult.getResponse().getStatus());

        String content = mvcResult.getResponse().getContentAsString();
        assertEquals("Empty Request", content);
    }

    private MvcResult getResultFromEndpoint(String uri, String jsonRequest) throws Exception {
        return mockMvc.perform(post(uri)
                .contentType("application/json")
                .content(jsonRequest))
                .andReturn();
    }

    private String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

}

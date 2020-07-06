package com.tutorial.softwarepractice.service;

import com.tutorial.softwarepractice.model.Info;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(StringAppendService.class)
public class StringAppendServiceTest {

    private final StringAppendService stringAppendService;

    @Autowired
    public StringAppendServiceTest(StringAppendService stringAppendService) {
        this.stringAppendService = stringAppendService;
    }

    @Test
    public void given_a_valid_keyword_should_get_the_201_response_code_and_body() {

        Info info = new Info("Java");
        ResponseEntity<String> result = stringAppendService.addStringAppend(info);

        assertEquals(201, result.getStatusCodeValue());
        assertEquals("CREATED", result.getStatusCode().name());
        assertEquals("Java is cool", result.getBody());
    }

    @Test
    public void given_an_invalid_keyword_should_get_a_400_response_code_and_body() {

        Info info = new Info("");
        ResponseEntity<String> result = stringAppendService.addStringAppend(info);

        assertEquals(400, result.getStatusCodeValue());
        assertEquals("BAD_REQUEST", result.getStatusCode().name());
        assertEquals("Empty Request", result.getBody());
    }
}

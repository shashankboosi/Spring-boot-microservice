package com.tutorial.softwarepractice.service;

import com.tutorial.softwarepractice.model.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class StringAppendService {

    private final String stringKeyAppend;

    @Autowired
    public StringAppendService(@Value("${string.append.value}") String stringKeyAppend) {
        this.stringKeyAppend = stringKeyAppend;
    }

    public ResponseEntity<String> addStringAppend(Info info) {

        if (!info.getKeyword().isEmpty()) {
            return new ResponseEntity<>(info.getKeyword() + stringKeyAppend, HttpStatus.CREATED);
        }

        return new ResponseEntity<>("Empty Request", HttpStatus.BAD_REQUEST);
    }
}

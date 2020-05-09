package com.tutorial.softwarepractice.controller;

import com.tutorial.softwarepractice.model.Info;
import com.tutorial.softwarepractice.service.StringAppendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringAppendController {

    private final StringAppendService stringAppendService;

    @Autowired
    public StringAppendController(StringAppendService stringAppendService) {
        this.stringAppendService = stringAppendService;
    }

    @PostMapping(value = "/append", consumes = "application/json")
    public ResponseEntity<String> addStringAppend(@RequestBody Info info) {
        return stringAppendService.addStringAppend(info);
    }
}

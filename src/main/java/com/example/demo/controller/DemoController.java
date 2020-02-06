package com.example.demo.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DemoService;
import com.example.demo.api.Demo;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class DemoController {

    private DemoService service;

    @GetMapping("demo")
    public ResponseEntity<String> processDemo(@RequestParam String param) {
        return processDemoRequest(param);
    }

    @PostMapping("demoPost")
    public ResponseEntity<String> processDemoPost(@RequestBody Demo demo) {
        String param = demo.getParam();
        return processDemoRequest(param);
    }

    private ResponseEntity<String> processDemoRequest(String param) {
        if (StringUtils.isBlank(param)) {
            return new ResponseEntity<>("Input is blank", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.demo(param), HttpStatus.OK);
    }

}

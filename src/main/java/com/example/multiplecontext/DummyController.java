package com.example.multiplecontext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {
    @GetMapping
    public void dummyMethod() {
    }
}

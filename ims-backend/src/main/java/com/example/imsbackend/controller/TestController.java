package com.example.imsbackend.controller;

import com.example.imsbackend.domain.ResultBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Silvery
 * @since 2023/10/31 15:15
 */
@RestController
public class TestController {

    @GetMapping("/")
    public String test() {
        return "1111";
    }
}

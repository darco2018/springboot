package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ColorController {

    private MyService myService;

    public ColorController(MyService myService) {
        this.myService = myService;
    }
 // zamiana na construcotr injection generates 20 words more loggin
    /*@Autowired
    private MyService myService;*/

    @GetMapping("/")
    public String getColor() {
        log.info(">>>>>>>>>>>>>>>>>>>> Color controller called <<<<<<<<<<<<<<<<<<<");
        return this.myService.getColor();
    }
}

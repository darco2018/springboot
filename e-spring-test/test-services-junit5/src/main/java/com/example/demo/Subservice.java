package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class Subservice {

    public Subservice(){}

    public String getAnimal(){
        log.info("########## ANIMAL SUB ##########");

        return "lion";
    }
}

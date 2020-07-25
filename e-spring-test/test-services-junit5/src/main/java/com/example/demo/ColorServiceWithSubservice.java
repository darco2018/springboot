package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ColorServiceWithSubservice {

    //@Autowired
    private Subservice subservice;

    public ColorServiceWithSubservice(Subservice subservice) {
        this.subservice = subservice;
    }

    public String getColor(){
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@ MYSERVICE @@@@@@@@@@@@@@@@@@@@@@@@");
        String animal = this.subservice.getAnimal();
        return "black " + animal;
    }

}

package com.example.demo.withSubservice;


import com.example.demo.ColorServiceWithSubservice;
import com.example.demo.DemoApplication;
import com.example.demo.MyService;
import com.example.demo.Subservice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


public class WithSubserviceTest_3_noSB {

    private static ColorServiceWithSubservice colorService;

    private static Subservice subservice;

    @BeforeAll
    public static void init(){
        // initialized only once (consider using @BeforeEach)
        subservice = new Subservice();
        colorService = new ColorServiceWithSubservice(subservice);
    }


    @Test
    public void getColorTest(){
        String actual = this.colorService.getColor();
        Assertions.assertThat(actual).isEqualTo("black lion");
    }
}

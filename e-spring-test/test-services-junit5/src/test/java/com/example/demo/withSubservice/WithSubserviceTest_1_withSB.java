package com.example.demo.withSubservice;


import com.example.demo.ColorServiceWithSubservice;
import com.example.demo.DemoApplication;
import com.example.demo.Subservice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { DemoApplication.class })
public class WithSubserviceTest_1_withSB {

    @Autowired
    private ColorServiceWithSubservice colorService;

    @Autowired
    private Subservice subservice;

     //   Test_1 runs about 2/3 of the time this test runs
    @Test
    public void getColorTest(){
        String actual = this.colorService.getColor();
        Assertions.assertThat(actual).isEqualTo("black lion");
    }
}

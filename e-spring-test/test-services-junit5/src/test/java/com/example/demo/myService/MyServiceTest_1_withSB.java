package com.example.demo.myService;


import com.example.demo.DemoApplication;
import com.example.demo.MyService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


//The 2 annos below replace @SpringBootTest  (classes = {MyService.class})

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { DemoApplication.class })
public class MyServiceTest_1_withSB {

    @Autowired
    private MyService myService;

    @RepeatedTest(1000)
    public void getColorTest(){
        String actual = this.myService.getColor();
        Assertions.assertThat(actual).isEqualTo("black");
    }
}

package com.example.demo.myService;


import com.example.demo.MyService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*@SpringBootTest bez ograniczen klasy - has a few extra lines
 Could not detect default configuration classes for test class
  Found @SpringBootConfiguration com.example.demo.DemoApplicat*/

@SpringBootTest  (classes = {MyService.class})
public class MyServiceTest_2_withSB {

    @Autowired // must be @SpringBootTest
    private MyService myService;

    @Test
    public void getColorTest(){
        String actual = this.myService.getColor();
        Assertions.assertThat(actual).isEqualTo("black");
    }
}

package com.example.demo.myService;


import com.example.demo.MyService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class MyServiceTest_3_Unit {

    private static MyService myService;

    @BeforeAll
    public static void init(){
        // initialized only once (consider using @BeforeEach)
        myService = new MyService();
    }

    @Test
    public void getColorTest(){
        String actual = this.myService.getColor();
        Assertions.assertThat(actual).isEqualTo("black");
    }
}

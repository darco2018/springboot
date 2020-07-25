package com.example.demo.withSubservice;


import com.example.demo.ColorServiceWithSubservice;
import com.example.demo.Subservice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
public class WithSubserviceTest_4_Mockito {

    // Unlike the mock() method, we need to enable Mockito annotations to use this annotation.
    @Mock // a shorthand for the Mockito.mock()
    private  Subservice subservice;

    private  ColorServiceWithSubservice colorService;

    // IMPORTANT: Use @BeforeEach, as the state of services could have changed beteen tests
    @BeforeEach
    public  void init(){
        colorService = new ColorServiceWithSubservice(subservice);
    }

    @Test
    public void getColorTest(){

        Mockito.when(subservice.getAnimal()).thenReturn("lion");

        String actual = this.colorService.getColor();
        Assertions.assertThat(actual).isEqualTo("black lion");
    }
}

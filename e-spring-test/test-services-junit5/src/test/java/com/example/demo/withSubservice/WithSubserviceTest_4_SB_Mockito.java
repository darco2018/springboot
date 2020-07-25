package com.example.demo.withSubservice;


import com.example.demo.ColorServiceWithSubservice;
import com.example.demo.DemoApplication;
import com.example.demo.Subservice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*  @MockBean ia SB wrapper around @Mock to add mock objects to the Spring application context. The mock will replace any existing bean of
the same type in the application context.
If no bean of the same type is defined, a new one will be added. This annotation is useful in integration tests where
a particular bean – for example, an external service – needs to be mocked.
To use this annotation, we have to use SpringRunner*/

/*@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DemoApplication.class})*/
@SpringBootTest(classes = {Subservice.class, ColorServiceWithSubservice.class})
public class WithSubserviceTest_4_SB_Mockito {
    @MockBean
    private Subservice subservice;

    @Autowired     // if doesnt get initialized - why?! Autowired annotation is not supported on static fields
    private ColorServiceWithSubservice colorService;

    @Test
    public void getColorTest(){

        Mockito.when(subservice.getAnimal()).thenReturn("lion");

        String actual = this.colorService.getColor();
        Assertions.assertThat(actual).isEqualTo("black lion");
    }
}

package com.example.demo.withSubservice;

import com.example.demo.ColorServiceWithSubservice;
import com.example.demo.Subservice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*@SpringBootTest - has a few extra lines
 Could not detect default configuration classes for test class
  Found @SpringBootConfiguration com.example.demo.DemoApplicat*/

@SpringBootTest(classes = {ColorServiceWithSubservice.class, Subservice.class})
public class WithSubserviceTest_2_withSB {

    @Autowired
    private ColorServiceWithSubservice colorService;

    //Failed to load ApplicationContext. NoSuchBeanDefinitionException if you don't declare subservice here in the test
    //depending on whether subservice is injected into filed or into constructor will result in different
    // logging messages but the overall result is the same
    @Autowired
    private Subservice subservice;

    // runs about 2/3 of the time Test_2_withSB
    @Test
    public void getColorTest() {
        String actual = this.colorService.getColor();
        Assertions.assertThat(actual).isEqualTo("black lion");
    }
}

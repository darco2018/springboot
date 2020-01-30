package com.example.bootifultesting;


import com.example.bootifultesting.example2.TaxService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TaxService.class)
// @SpringBootTest(classes = {EmployeeRepository.class, EmployeeService.class})
public class TaxServiceTest {

    @Autowired
    private TaxService service;

    @Disabled("Not implemented yet")
    @Test
    public void xxx(){

    }

    // new name will be visible in ideas run panel
    @DisplayName("Single test successful")
    @Test
    public void brackets(){
        final String taxBracket = this.service.getBrackets(500);
        Assertions.assertThat(taxBracket).isEqualTo("LOW");
    }

    @Test
    public void allBrackets(){
        final List<String> allBrackets = this.service.allBrackets();
        Assertions.assertThat(allBrackets).isNotEmpty();
        Assertions.assertThat(allBrackets).contains("LOW", "MEDIUM", "HIGH")
                .doesNotContain("SUPER")
                .startsWith("LOW");
    }
}

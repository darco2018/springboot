package com.example.bootifultesting;

import com.example.bootifultesting.example2.External;
import com.example.bootifultesting.example2.TaxService222;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//BE CAREFUL:  classes = TaxService222.class limits Spring scan to this class & Spring cannot see External class if you dont add it here as well.
// (you will get no bean of this type can be injected
// you could also run it without specifing classes to initizlize, to run the whole context
@SpringBootTest(classes = {TaxService222.class, External.class})
public class TaxService222Test {

    private static TaxService222 service222;


    // initalizing External in constructor happens only once, not before each method, so changing state
    // in one of the methods could influance others

    @BeforeEach
    public static void init(){
        External external = new External();
        service222 = new TaxService222(external);
    }


    @Test
    public void brackets(){
        final String taxBracket = this.service222.getBrackets(500);
        Assertions.assertThat(taxBracket).isEqualTo("LOW");
    }

    @Test
    public void allBrackets(){
        final List<String> allBrackets = this.service222.allBrackets();
        Assertions.assertThat(allBrackets).isNotEmpty();
        Assertions.assertThat(allBrackets).contains("LOW", "MEDIUM", "HIGH")
                .doesNotContain("SUPER")
                .startsWith("LOW");
    }

}

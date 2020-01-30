package com.example.bootifultesting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

// this would load the entire app with tomcat: @SpringBootTest(classes = )
@DataJpaTest // transactional, uses h2, autoconfigures testEntityManagera
//@TestPropertySource(locations = "classpath:application-test.properties")
public class ReservationJPAtest  {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testMapping(){
        Reservation jane = this.entityManager.persistFlushFind(new Reservation(null, "Jane"));
        Assertions.assertThat(jane.getReservationName()).isEqualTo("Jane");
        Assertions.assertThat(jane.getId()).isNotNull();
        Assertions.assertThat(jane.getId()).isGreaterThan(0);
    }
}

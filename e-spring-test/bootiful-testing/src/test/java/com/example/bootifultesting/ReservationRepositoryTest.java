package com.example.bootifultesting;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test; // org.junit.Test
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collection;

@DataJpaTest // is already annotated with @ExtendWith({SpringExtension.class}) - formerly @RunWith(SpringRunner.class)
public class ReservationRepositoryTest {

    // dont test spring-data methods - we know they work fine
    // but we can test our custom methods

    @Autowired
    private ReservationRepository repository;

    @Test
    public  void findByReservationName(){

        this.repository.save(new Reservation(null, "Jane"));
        Collection<Reservation> byReservationName = this.repository.findByReservationName("Jane");
        Assertions.assertThat(byReservationName.iterator().next().getId()).isGreaterThan(0);
        Assertions.assertThat(byReservationName.iterator().next().getReservationName()).isEqualTo("Jane");


    }
}

package com.example.bootifultesting;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReservationTest {

    // 	@Disabled
    @Test
    public void createReservation(){
        Reservation r = new Reservation(1L, "Jane");

        org.junit.jupiter.api.Assertions.assertEquals(r.getId(), (Long)1L);
        org.assertj.core.api.Assertions.assertThat(r.getId()).isEqualTo(1L);
        org.assertj.core.api.Assertions.assertThat(r.getReservationName()).isNotBlank();
        org.assertj.core.api.Assertions.assertThat(r.getReservationName()).isEqualTo("Jane");
    }
}

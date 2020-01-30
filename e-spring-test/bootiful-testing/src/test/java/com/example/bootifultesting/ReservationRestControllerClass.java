package com.example.bootifultesting;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


@WebMvcTest
// how to exclude classes eg securoty class:
// @EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
// or
// @ActiveProfiles("test")
// spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
public class ReservationRestControllerClass {


     /*
    @Configuration
    public static class MyConfig {
       @Bean
        ReservationRepository reservationRepository(){
            ReservationRepository mock = Mockito.mock(ReservationRepository.class);
            Mockito.when(mock.findAll()).thenReturn(Arrays.asList(new Reservation(1L, "Jane")));
            return mock;
        }
    }

    the above is achieved by MockBean
    */

    // were not testing db here, we know it works, we have testedit in a different test;
    //the anno tells spring:  provide a bean like this if it doesnt exist; or if it exists, replace it with a mock

     @org.springframework.boot.test.mock.mockito.MockBean
     private ReservationRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getReservations() throws Exception {

        Mockito.when(this.repository.findAll())
                .thenReturn(Collections.singletonList(new Reservation(1L, "Jane")));// Collections.emptyList()

        // were not really making an http call, no socket open listening for requests - client talks to SpringMvc, not to Tomcat
        mockMvc.perform(MockMvcRequestBuilders
                .get("/reservations")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect( MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].reservationName").value("Jane"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getReservationsTwo() throws Exception {

        // this makes it a unit test, as repo -an external service - will not be called, just a mock will be created
        Mockito.when(this.repository
                                 .findAll())
                                 .thenReturn(Collections.emptyList());
        //Lists.newArrayList("1","2","3");

        // were not really making an http call, no socket open listening for requests - client talks to SpringMvc, not to Tomcat
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/reservations")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();


        Mockito.verify(this.repository).findAll(); // verify if the method was called. You can also use Coverage.
    }


}

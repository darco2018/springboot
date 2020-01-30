package com.example.bootifultesting.employee;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

@SpringBootTest
public class EmployeeServiceImplIntegrationTest {

    /*  we can create a @TestConfiguration class to initialize some beans for testing class only.

    To check the Service class, we need to have an instance of Service class created and available as a @Bean so that
     we can @Autowire it in our test class. This configuration is achieved by using the @TestConfiguration annotation.

    During component scanning, we might find components or configurations created only for specific tests accidentally get
    picked up everywhere. To help prevent that, Spring Boot provides @TestConfiguration annotation that can be used on
    classes in src/test/java to indicate that:
       they should not be picked up by scanning.

       A nested @TestConfiguration class is used “in addition to” the application’s primary configuration.
       */

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        // tests specific beans
        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }

    @Autowired
    private EmployeeService employeeService;

    // It creates a Mock for the EmployeeRepository which can be used to bypass the call to the actual EmployeeRepository:
    @MockBean
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setUp() {
        Employee alex = new Employee("alex");

        Mockito.when(employeeRepository.findByName(alex.getName()))
                .thenReturn(alex);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "alex";
        Employee found = employeeService.getEmployeeByName(name);

        Assertions.assertThat(found.getName())
                .isEqualTo(name);
    }



}

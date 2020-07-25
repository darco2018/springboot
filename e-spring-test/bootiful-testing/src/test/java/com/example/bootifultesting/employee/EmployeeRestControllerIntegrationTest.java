package com.example.bootifultesting.employee;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/* The @SpringBootTest annotation can be used when we need to bootstrap the entire container. The annotation works by
 creating the ApplicationContext that will be utilized in our tests. */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
// WebEnvironment.MOCK here – so that the container will operate in a mock servlet environment.
@AutoConfigureMockMvc

// @TestPropertySource will override the existing application.properties file.
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class EmployeeRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private EmployeeRepository repository;

    // write test cases here
    @
            Test
    public void givenEmployees_whenGetEmployees_thenStatus200()
            throws Exception {

        createTestEmployee("bob");

        // given when then ??

        mvc.perform(get("/api/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                /*.andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))*/
                .andExpect(jsonPath("$[0].name").value("bob"));
    }

    private void createTestEmployee(String name) {
        Employee employee = new Employee(name);
        this.repository.saveAndFlush(employee);
    }


}

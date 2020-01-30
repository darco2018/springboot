package cloud.javacoder.car.sbtesting.web;

import cloud.javacoder.car.sbtesting.domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

// the same package org.springframework.test.web.servlet. */result/request
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
                                    // MockMvcResultMatchers:
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class) // loads context relevant to MVC, will wire up the controller;
// doesnt start the server but uses MockMvc to directly test the controler
public class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // mocks a component in a test
    @MockBean // without it you will get org.springframework.beans.factory.NoSuchBeanDefinitionException
    // even if you have the bean
    private CarService carService;

    // slice test - we're only testing controller
    @Test
    public void getCar_shouldReturnCar() throws Exception{
        BDDMockito
                .given(carService.getCarDetails(org.mockito.ArgumentMatchers.anyString()))
                .willReturn(new Car("prius", "hybrid")); // currently getCarDetails() returns null - we dont have
        // the implementation yet, but this will mock the implementation

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
                .andExpect(status().isOk())
                .andExpect(  jsonPath("name").value("prius")  )
                .andExpect( jsonPath("type").value("hybrid"));
    }

    @Test
    public void getCar_notFound() throws Exception{
        BDDMockito
                .given(carService.getCarDetails(org.mockito.ArgumentMatchers.anyString()))
                .willThrow(new CarNotFoundException());

                mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
                .andExpect(status().isNotFound());
    }
}

package cloud.javacoder.car.sbtesting.service;

import cloud.javacoder.car.sbtesting.domain.Car;
import cloud.javacoder.car.sbtesting.web.CarNotFoundException;
import cloud.javacoder.car.sbtesting.web.CarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/* PURE UNIT TEST without involving Spring at all*/

@RunWith(MockitoJUnitRunner.class) // this will exclude Spring - we just test service & repo
public class CarServiceTest {

    @Mock // used with MockitoJUnitRunner;    Similar to @MockBean + SpringRunner
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setUp() throws Exception{
        carService= new CarService(carRepository);
    }

    @Test
    public void getCarDetails_returnsCarInfo(){
        // arrange
        BDDMockito.given(carRepository.findByName("prius"))
                .willReturn(new Car("prius", "hybrid"));

        //act
        Car car = carService.getCarDetails("prius");

        //assert
        org.assertj.core.api.Assertions.assertThat( car.getName() ).isEqualTo("prius");
        org.assertj.core.api.Assertions.assertThat( car.getType()).isEqualTo("hybrid");
    }

    @Test(expected = CarNotFoundException.class)
    public void getCarDetails_whenCarNotFound() throws Exception{
        BDDMockito.given(this.carRepository.findByName("prius"))
                .willReturn(null);
        // act
        carService.getCarDetails("prius");

        // assert
    }



}
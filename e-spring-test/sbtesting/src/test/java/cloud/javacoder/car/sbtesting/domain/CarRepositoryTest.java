package cloud.javacoder.car.sbtesting.domain;

import cloud.javacoder.car.sbtesting.service.CarRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

// java.lang.NoClassDefFoundError: org/springframework/dao/DataAccessException if not data-jpa on classpath

// @RunWith(SpringRunner.class)  //Dont use @RunWith(SpringRunner.class) - With that annotation there is JUnit Vintage running which can't find any tests and gives you the error "no runnable methods"
// JUPITER: @RunWith annotation has been replaced by the more powerful @ExtendWith
@DataJpaTest
/* Loads jpa relevant config; uses in-memory db by default, override with @AutoConfigureTestDatabase + h2*/
public class CarRepositoryTest  {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findbyName_returnsCar() throws Exception{
        //    carRepository.save() would just save it to the cashe & findByName would get it from the cashe
        Car savedCar = entityManager.persistFlushFind(new Car("prius", "hybrid"));
        Car car = carRepository.findByName("prius");

        Assertions.assertThat(car.getName()).isEqualTo("prius");
        Assertions.assertThat(car.getType()).isEqualTo("hybrid");
    }
}

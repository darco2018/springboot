package cloud.javacoder.car.sbtesting.service;

import cloud.javacoder.car.sbtesting.domain.Car;
import org.mockito.BDDMockito;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Long> {
   Car findByName(String prius);
}

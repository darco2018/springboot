package cloud.javacoder.car.sbtesting.web;


import cloud.javacoder.car.sbtesting.domain.Car;
import cloud.javacoder.car.sbtesting.service.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name) {
        Car car = this.carRepository.findByName(name);
        if (car == null){
            throw new CarNotFoundException();
        }
        return car;
    }
}

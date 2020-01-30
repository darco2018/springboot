package cloud.javacoder.car.sbtesting.web;

import cloud.javacoder.car.sbtesting.domain.Car;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// cloud.javacoder.car.sbtesting.web.CarService

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name){
        return carService.getCarDetails(name); // new Car( name, type) will be returned as JSON
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void carNotFoundHandler(CarNotFoundException ex){
        // CarNotFoundException is passed here by Spring and a resonse is generated with status 404
    }
}

package cloud.javacoder.car.sbtesting.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND) //- if you use it, you dont need a separate exception handling method in a controller
public class CarNotFoundException extends RuntimeException {
}

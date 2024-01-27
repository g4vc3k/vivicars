package pl.wypozyczalnia.vivicars.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wypozyczalnia.vivicars.model.Car;
import pl.wypozyczalnia.vivicars.service.CarService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/cars")
    public List<Car> getCars(@RequestParam(required = false)Integer page){
        return carService.getCars(page);
    }
    @GetMapping("/cars/{id}")
    public Car getSingleCar(@PathVariable long id){
        return carService.getSingleCar(id);}
    }



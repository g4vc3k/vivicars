package pl.wypozyczalnia.vivicars.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.wypozyczalnia.vivicars.model.Car;
import pl.wypozyczalnia.vivicars.repository.CarRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    public List<Car> getCars(Integer page){
        return carRepository.findAllCars(PageRequest.of(page, 5));
    }

    public Car getSingleCar(long id) {
        return carRepository.findById(id)
                .orElseThrow();
    }
}

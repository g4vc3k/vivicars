package pl.wypozyczalnia.vivicars.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wypozyczalnia.vivicars.model.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("Select c From Car c")
    List<Car> findAllCars(Pageable page);

}

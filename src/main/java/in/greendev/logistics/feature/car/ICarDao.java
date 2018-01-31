package in.greendev.logistics.feature.car;

import org.springframework.data.jpa.repository.JpaRepository;

import in.greendev.logistics.model.Car;

public interface ICarDao extends JpaRepository<Car, Long>{

}

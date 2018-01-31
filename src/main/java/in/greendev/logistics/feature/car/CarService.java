package in.greendev.logistics.feature.car;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.greendev.logistics.model.Car;

@Service
@Transactional
public class CarService implements ICarService {

	private final ICarDao carDao;

	
	public CarService(ICarDao carDao) {
        this.carDao = carDao;
	}

	@Override
	public List<Car> findAll() {
		return carDao.findAll();
	}

	@Override
	public Car getOne(Long id) {
		return carDao.getOne(id);
	}

	@Override
	public void delete(Car car) {
		carDao.delete(car);
	}

	@Override
	public void save(Car car) {
		carDao.save(car);
	}

	@Override
	public void deleteById(Long id) {
		carDao.delete(id);
	}

    @Override
    public Page<Car> listAllByPage(Pageable pageable) {
		return  carDao.findAll(pageable);
    }
}

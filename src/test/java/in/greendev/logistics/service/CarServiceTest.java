package in.greendev.logistics.service;

import in.greendev.logistics.feature.car.CarService;
import in.greendev.logistics.feature.car.ICarDao;
import in.greendev.logistics.model.Car;
import in.greendev.logistics.util.TestEntityProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class CarServiceTest {

    @Mock
    private ICarDao carDao;

    private CarService carService;

    @Before
    public void setUpMock(){
        MockitoAnnotations.initMocks(this);
        carService = new CarService(carDao);
    }

    @Test
    public void shouldFindAll() {
        Mockito.when(carDao.findAll()).thenReturn(TestEntityProvider.CARS);
        final List<Car> cars = carService.findAll();
        Mockito.verify(carDao).findAll();
        Assert.assertEquals(TestEntityProvider.CARS.size(), cars.size());
    }

    @Test
    public void shouldBePageable() {
        Mockito.when(carDao.findAll(TestEntityProvider.pageRequest)).thenReturn(TestEntityProvider.CARS_PAGE);
        final Page<Car> cars = carService.listAllByPage(TestEntityProvider.pageRequest);
        Mockito.verify(carDao).findAll(TestEntityProvider.pageRequest);
        Assert.assertEquals(TestEntityProvider.CARS_PAGE.getTotalPages(), cars.getTotalPages());
        Assert.assertEquals(TestEntityProvider.CARS_PAGE.getTotalElements(), cars.getTotalElements());
    }

    @Test
    public void shouldGetOne(){
        Mockito.when(carDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.CAR1);
        final Car car = carService.getOne(Matchers.anyLong());
        Mockito.verify(carDao).getOne(Matchers.anyLong());
        Assert.assertEquals(TestEntityProvider.CAR1.getName(), car.getName());
    }

    @Test
    public void shouldDelete(){
        Mockito.doNothing().when(carDao).delete(Matchers.any(Car.class));
        carService.delete(TestEntityProvider.CAR1);
        Mockito.verify(carDao).delete(Matchers.any(Car.class));
    }

    @Test
    public void shouldDeleteById(){
        Mockito.doNothing().when(carDao).delete(Matchers.anyLong());
        carService.deleteById(Matchers.anyLong());
        Mockito.verify(carDao).delete(Matchers.anyLong());
    }

    @Test
    public void shouldSave(){
        Mockito.when(carDao.save(TestEntityProvider.CAR1)).thenReturn(TestEntityProvider.CAR1);
        carService.save(TestEntityProvider.CAR1);
        Mockito.verify(carDao).save(TestEntityProvider.CAR1);
    }

}

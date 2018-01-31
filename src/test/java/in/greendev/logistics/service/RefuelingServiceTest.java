package in.greendev.logistics.service;

import in.greendev.logistics.feature.refueling.IRefuelingDao;
import in.greendev.logistics.feature.refueling.IRefuelingService;
import in.greendev.logistics.feature.refueling.RefuelingService;
import in.greendev.logistics.model.Refueling;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:test.properties")
public class RefuelingServiceTest {

    @Mock
    private IRefuelingDao refuelingDao;

    private IRefuelingService refuelingService;

    @Before
    public void setUpMock() {
        MockitoAnnotations.initMocks(this);
        refuelingService = new RefuelingService(refuelingDao);
    }

    @Test
    public void shouldFindAll() {
        Mockito.when(refuelingDao.findAll()).thenReturn(TestEntityProvider.REFUELINGS);
        final List<Refueling> refuelings = refuelingService.findAll();
        Mockito.verify(refuelingDao).findAll();
        Assert.assertEquals(TestEntityProvider.REFUELINGS.size(), refuelings.size());
    }

    @Test
    public void shouldBePageable() {
        Mockito.when(refuelingDao.findAll(TestEntityProvider.pageRequest)).thenReturn(TestEntityProvider.REFUELING_PAGE);
        final Page<Refueling> refuelingPage = refuelingService.listAllByPage(TestEntityProvider.pageRequest);
        Mockito.verify(refuelingDao).findAll(TestEntityProvider.pageRequest);
        Assert.assertEquals(TestEntityProvider.REFUELING_PAGE.getTotalPages(), refuelingPage.getTotalPages());
        Assert.assertEquals(TestEntityProvider.REFUELING_PAGE.getTotalElements(), refuelingPage.getTotalElements());
    }

    @Test
    public void shouldGetOne() {
        Mockito.when(refuelingDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.REFUELING1);
        final Refueling refueling = refuelingService.getOne(Matchers.anyLong());
        Mockito.verify(refuelingDao).getOne(Matchers.anyLong());
        Assert.assertEquals(TestEntityProvider.REFUELING1.getDriverName(), refueling.getDriverName());
    }

    @Test
    public void shouldDelete() {
        Mockito.doNothing().when(refuelingDao).delete(Matchers.any(Refueling.class));
        refuelingService.delete(TestEntityProvider.REFUELING1);
        Mockito.verify(refuelingDao).delete(Matchers.any(Refueling.class));
    }

    @Test
    public void shouldDeleteById() {
        Mockito.doNothing().when(refuelingDao).delete(Matchers.anyLong());
        refuelingService.deleteById(Matchers.anyLong());
        Mockito.verify(refuelingDao).delete(Matchers.anyLong());
    }

    @Test
    public void shouldSave() {
        Mockito.when(refuelingDao.save(TestEntityProvider.REFUELING1))
                .thenReturn(TestEntityProvider.REFUELING1);
        refuelingService.save(TestEntityProvider.REFUELING1);
        Mockito.verify(refuelingDao).save(TestEntityProvider.REFUELING1);
    }
}


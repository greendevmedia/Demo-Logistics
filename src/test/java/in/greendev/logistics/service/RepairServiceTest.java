package in.greendev.logistics.service;

import in.greendev.logistics.feature.repair.IRepairDao;
import in.greendev.logistics.feature.repair.IRepairService;
import in.greendev.logistics.feature.repair.RepairService;
import in.greendev.logistics.model.Repair;
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
public class RepairServiceTest {

    @Mock
    private IRepairDao repairDao;

    private IRepairService repairService;

    @Before
    public void setUpMock() {
        MockitoAnnotations.initMocks(this);
        repairService = new RepairService(repairDao);
    }

    @Test
    public void shouldFindAll() {
        Mockito.when(repairDao.findAll()).thenReturn(TestEntityProvider.REPAIRS);
        final List<Repair> repairs = repairService.findAll();
        Mockito.verify(repairDao).findAll();
        Assert.assertEquals(TestEntityProvider.REPAIRS.size(), repairs.size());
    }

    @Test
    public void shouldBePageable() {
        Mockito.when(repairDao.findAll(TestEntityProvider.pageRequest)).thenReturn(TestEntityProvider.REPAIRS_PAGE);
        final Page<Repair> repairPage = repairService.listAllByPage(TestEntityProvider.pageRequest);
        Mockito.verify(repairDao).findAll(TestEntityProvider.pageRequest);
        Assert.assertEquals(TestEntityProvider.REPAIRS_PAGE.getTotalPages(), repairPage.getTotalPages());
        Assert.assertEquals(TestEntityProvider.REPAIRS_PAGE.getTotalElements(), repairPage.getTotalElements());
    }

    @Test
    public void shouldGetOne() {
        Mockito.when(repairDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.REPAIR1);
        final Repair repair = repairService.getOne(Matchers.anyLong());
        Mockito.verify(repairDao).getOne(Matchers.anyLong());
        Assert.assertEquals(TestEntityProvider.REPAIR1.getActivityType(), repair.getActivityType());
    }

    @Test
    public void shouldDelete() {
        Mockito.doNothing().when(repairDao).delete(Matchers.any(Repair.class));
        repairService.delete(TestEntityProvider.REPAIR1);
        Mockito.verify(repairDao).delete(Matchers.any(Repair.class));
    }

    @Test
    public void shouldDeleteById() {
        Mockito.doNothing().when(repairDao).delete(Matchers.anyLong());
        repairService.deleteById(Matchers.anyLong());
        Mockito.verify(repairDao).delete(Matchers.anyLong());
    }

    @Test
    public void shouldSave() {
        Mockito.when(repairDao.save(TestEntityProvider.REPAIR1)).thenReturn(TestEntityProvider.REPAIR1);
        repairService.save(TestEntityProvider.REPAIR1);
        Mockito.verify(repairDao).save(TestEntityProvider.REPAIR1);
    }
}

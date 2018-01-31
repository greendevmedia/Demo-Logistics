package in.greendev.logistics.service;

import in.greendev.logistics.feature.additionalPaymentName.AdditionalPaymentNameService;
import in.greendev.logistics.feature.additionalPaymentName.IAdditionalPaymentNameDao;
import in.greendev.logistics.feature.additionalPaymentName.IAdditionalPaymentNameService;
import in.greendev.logistics.model.AdditionalPaymentName;
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
public class AdditionalPaymentNameServiceTest {

    @Mock
    private IAdditionalPaymentNameDao additionalPaymentNameDao;

    private IAdditionalPaymentNameService additionalPaymentNameService;

    @Before
    public void setUpMock() {
        MockitoAnnotations.initMocks(this);
        additionalPaymentNameService = new AdditionalPaymentNameService(additionalPaymentNameDao);
    }

    @Test
    public void shouldFindAll() {
        Mockito.when(additionalPaymentNameDao.findAll()).thenReturn(TestEntityProvider.ADDITIONAL_PAYMENT_NAMES);
        final List<AdditionalPaymentName> additionalPaymentNames = additionalPaymentNameService.findAll();
        Mockito.verify(additionalPaymentNameDao).findAll();
        Assert.assertEquals(TestEntityProvider.ADDITIONAL_PAYMENT_NAMES.size(), additionalPaymentNames.size());
    }

    @Test
    public void shouldBePageable() {
        Mockito.when(additionalPaymentNameDao.findAll(TestEntityProvider.pageRequest)).thenReturn(TestEntityProvider.TRAILER_PAGE);
        final Page<AdditionalPaymentName> additionalPaymentNamePage = additionalPaymentNameService.listAllByPage(TestEntityProvider.pageRequest);
        Mockito.verify(additionalPaymentNameDao).findAll(TestEntityProvider.pageRequest);
        Assert.assertEquals(TestEntityProvider.TRAILER_PAGE.getTotalPages(), additionalPaymentNamePage.getTotalPages());
        Assert.assertEquals(TestEntityProvider.TRAILER_PAGE.getTotalElements(), additionalPaymentNamePage.getTotalElements());
    }

    @Test
    public void shouldGetOne() {
        Mockito.when(additionalPaymentNameDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.ADDITIONAL_PAYMENT_NAME1);
        final AdditionalPaymentName additionalPaymentName = additionalPaymentNameService.getOne(Matchers.anyLong());
        Mockito.verify(additionalPaymentNameDao).getOne(Matchers.anyLong());
        Assert.assertEquals(TestEntityProvider.ADDITIONAL_PAYMENT_NAME1.getPaymentName(), additionalPaymentName.getPaymentName());
    }

    @Test
    public void shouldDelete() {
        Mockito.doNothing().when(additionalPaymentNameDao).delete(Matchers.any(AdditionalPaymentName.class));
        additionalPaymentNameService.delete(TestEntityProvider.ADDITIONAL_PAYMENT_NAME1);
        Mockito.verify(additionalPaymentNameDao).delete(Matchers.any(AdditionalPaymentName.class));
    }

    @Test
    public void shouldDeleteById() {
        Mockito.doNothing().when(additionalPaymentNameDao).delete(Matchers.anyLong());
        additionalPaymentNameService.deleteById(Matchers.anyLong());
        Mockito.verify(additionalPaymentNameDao).delete(Matchers.anyLong());
    }

    @Test
    public void shouldSave() {
        Mockito.when(additionalPaymentNameDao.save(TestEntityProvider.ADDITIONAL_PAYMENT_NAME1)).thenReturn(TestEntityProvider.ADDITIONAL_PAYMENT_NAME1);
        additionalPaymentNameService.save(TestEntityProvider.ADDITIONAL_PAYMENT_NAME1);
        Mockito.verify(additionalPaymentNameDao).save(TestEntityProvider.ADDITIONAL_PAYMENT_NAME1);
    }
}

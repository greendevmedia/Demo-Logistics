package in.greendev.logistics.service;

import in.greendev.logistics.feature.additionalPayment.AdditionalPaymentService;
import in.greendev.logistics.feature.additionalPayment.IAdditionalPaymentDao;
import in.greendev.logistics.feature.additionalPayment.IAdditionalPaymentService;
import in.greendev.logistics.model.AdditionalPayment;
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
@Transactional
@TestPropertySource(locations = "classpath:test.properties")
@SpringBootTest
public class AdditionalPaymentServiceTest {

    @Mock
    private IAdditionalPaymentDao additionalPaymentDao;

    private IAdditionalPaymentService additionalPaymentService;

    @Before
    public void setUpMock() {
        MockitoAnnotations.initMocks(this);
        additionalPaymentService = new AdditionalPaymentService(additionalPaymentDao);
    }

    @Test
    public void shouldFindAll(){
        Mockito.when(additionalPaymentDao.findAll()).thenReturn(TestEntityProvider.ADDITIONAL_PAYMENTS);
        final List<AdditionalPayment> additionalPayments = additionalPaymentService.findAll();
        Mockito.verify(additionalPaymentDao).findAll();
        Assert.assertEquals(TestEntityProvider.ADDITIONAL_PAYMENTS.size(), additionalPayments.size());
    }

    @Test
    public void shouldBePageAble(){
        Mockito.when(additionalPaymentDao.findAll(TestEntityProvider.pageRequest)).thenReturn(TestEntityProvider.ADDITIONAL_PAYMENTS_PAGE);
        final Page<AdditionalPayment> additionalPaymentPage = additionalPaymentService.listAllByPage(TestEntityProvider.pageRequest);
        Mockito.verify(additionalPaymentDao).findAll(TestEntityProvider.pageRequest);
        Assert.assertEquals(TestEntityProvider.ADDITIONAL_PAYMENTS_PAGE.getTotalElements(), additionalPaymentPage.getTotalElements());
        Assert.assertEquals(TestEntityProvider.ADDITIONAL_PAYMENTS_PAGE.getTotalPages(), additionalPaymentPage.getTotalPages());
    }

    @Test
    public void shouldGetOne(){
        Mockito.when(additionalPaymentDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.ADDITIONAL_PAYMENT1);
        final AdditionalPayment additionalPayment = additionalPaymentService.getOne(Matchers.anyLong());
        Mockito.verify(additionalPaymentDao).getOne(Matchers.anyLong());
        Assert.assertEquals(TestEntityProvider.ADDITIONAL_PAYMENT1.getCar(), additionalPayment.getCar());
    }

    @Test
    public void shouldDelete(){
        Mockito.doNothing().when(additionalPaymentDao).delete(Matchers.any(AdditionalPayment.class));
        additionalPaymentService.delete(Matchers.any(AdditionalPayment.class));
        Mockito.verify(additionalPaymentDao).delete(Matchers.any(AdditionalPayment.class));
    }

    @Test
    public void shouldDeleteById(){
        Mockito.doNothing().when(additionalPaymentDao).delete(Matchers.anyLong());
        additionalPaymentService.deleteById(Matchers.anyLong());
        Mockito.verify(additionalPaymentDao).delete(Matchers.anyLong());
    }

    @Test
    public void shouldSave(){
        Mockito.when(additionalPaymentDao.save(TestEntityProvider.ADDITIONAL_PAYMENT1)).thenReturn(TestEntityProvider.ADDITIONAL_PAYMENT1);
        additionalPaymentService.save(TestEntityProvider.ADDITIONAL_PAYMENT1);
        Mockito.verify(additionalPaymentDao).save(TestEntityProvider.ADDITIONAL_PAYMENT1);
    }
}

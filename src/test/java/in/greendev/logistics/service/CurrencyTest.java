package in.greendev.logistics.service;

import in.greendev.logistics.feature.currency.CurrencyService;
import in.greendev.logistics.feature.currency.ICurrencyDao;
import in.greendev.logistics.model.Currency;
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
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class CurrencyTest {

    @Mock
    private ICurrencyDao currencyDao;

    private CurrencyService currencyService;

    @Before
    public void setUpMock(){
        MockitoAnnotations.initMocks(this);
        currencyService = new CurrencyService(currencyDao);
    }

    @Test
    public void shouldFindAll(){
        Mockito.when(currencyDao.findAll()).thenReturn(TestEntityProvider.CURRENCIES);
        final List<Currency> currencies = currencyService.findAll();
        Mockito.verify(currencyDao).findAll();
        Assert.assertEquals(currencies.size(), TestEntityProvider.CURRENCIES.size());
    }

    @Test
    public void shouldBePageable(){
        Mockito.when(currencyDao.findAll(TestEntityProvider.pageRequest)).thenReturn(TestEntityProvider.CURRENCIES_PAGE);
        final Page<Currency> currencyPage = currencyService.listAllByPage(TestEntityProvider.pageRequest);
        Mockito.verify(currencyDao).findAll(TestEntityProvider.pageRequest);
        Assert.assertEquals(TestEntityProvider.CURRENCIES_PAGE.getTotalElements(), currencyPage.getTotalElements());
        Assert.assertEquals(TestEntityProvider.CURRENCIES_PAGE.getTotalPages(), currencyPage.getTotalPages());
    }

    @Test
    public void shouldGetOne(){
        Mockito.when(currencyDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.CURRENCY1);
        final Currency currency = currencyService.getOne(Matchers.anyLong());
        Mockito.verify(currencyDao).getOne(Matchers.anyLong());
        Assert.assertEquals(TestEntityProvider.CURRENCY1.getCurrencyCode(), currency.getCurrencyCode());
    }

    @Test
    public void shouldDelete(){
        Mockito.doNothing().when(currencyDao).delete(Matchers.any(Currency.class));
        currencyService.delete(TestEntityProvider.CURRENCY1);
        Mockito.verify(currencyDao).delete(Matchers.any(Currency.class));
    }

    @Test
    public void shouldDeleteById(){
        Mockito.doNothing().when(currencyDao).delete(Matchers.anyLong());
        currencyService.deleteById(Matchers.anyLong());
        Mockito.verify(currencyDao).delete(Matchers.anyLong());
    }

    @Test
    public void shouldSave(){
        Mockito.when(currencyDao.save(TestEntityProvider.CURRENCY1)).thenReturn(TestEntityProvider.CURRENCY1);
        currencyService.save(TestEntityProvider.CURRENCY1);
        Mockito.verify(currencyDao).save(TestEntityProvider.CURRENCY1);
    }
}

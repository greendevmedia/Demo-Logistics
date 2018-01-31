package in.greendev.logistics.feature.currency;

import in.greendev.logistics.model.Currency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CurrencyService implements ICurrencyService{

    private final ICurrencyDao currencyDao;

    public CurrencyService(ICurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    @Override
    public List<Currency> findAll() {
        return currencyDao.findAll();
    }

    @Override
    public Currency getOne(Long id) {
        return currencyDao.getOne(id);
    }

    @Override
    public void delete(Currency currency) {
        currencyDao.delete(currency);
    }

    @Override
    public void save(Currency currency) {
        currencyDao.save(currency);
    }

    @Override
    public void deleteById(Long id) {
        currencyDao.delete(id);
    }

    @Override
    public Page<Currency> listAllByPage(Pageable pageable) {
        return currencyDao.findAll(pageable);
    }
}

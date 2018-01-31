package in.greendev.logistics.feature.additionalPaymentName;

import in.greendev.logistics.model.AdditionalPaymentName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdditionalPaymentNameService implements IAdditionalPaymentNameService {

    private final IAdditionalPaymentNameDao additionalPaymentNameDao;

    public AdditionalPaymentNameService(IAdditionalPaymentNameDao additionalPaymentNameDao){
        this.additionalPaymentNameDao = additionalPaymentNameDao;
    }

    @Override
    public List<AdditionalPaymentName> findAll() {
        return additionalPaymentNameDao.findAll();
    }

    @Override
    public AdditionalPaymentName getOne(Long id) {
        return additionalPaymentNameDao.getOne(id);
    }

    @Override
    public void delete(AdditionalPaymentName additionalPaymentName) {
        additionalPaymentNameDao.delete(additionalPaymentName);
    }

    @Override
    public void save(AdditionalPaymentName additionalPaymentName) {
        additionalPaymentNameDao.save(additionalPaymentName);
    }

    @Override
    public void deleteById(Long id) {
        additionalPaymentNameDao.delete(id);
    }

    @Override
    public Page<AdditionalPaymentName> listAllByPage(Pageable pageable) {
        return additionalPaymentNameDao.findAll(pageable);
    }
}

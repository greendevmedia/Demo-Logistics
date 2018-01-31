package in.greendev.logistics.feature.additionalPayment;

import in.greendev.logistics.model.AdditionalPayment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdditionalPaymentService implements IAdditionalPaymentService {

    private final IAdditionalPaymentDao additionalPaymentDao;

    public AdditionalPaymentService(IAdditionalPaymentDao additionalPaymentDao){
        this.additionalPaymentDao = additionalPaymentDao;
    }

    @Override
    public List<AdditionalPayment> findAll() {
        return additionalPaymentDao.findAll();
    }

    @Override
    public AdditionalPayment getOne(Long id) {
        return additionalPaymentDao.getOne(id);
    }

    @Override
    public void delete(AdditionalPayment additionalPayment) {
    additionalPaymentDao.delete(additionalPayment);
    }

    @Override
    public void save(AdditionalPayment additionalPayment) {
    additionalPaymentDao.save(additionalPayment);
    }

    @Override
    public void deleteById(Long id) {
        additionalPaymentDao.delete(id);
    }

    @Override
    public Page<AdditionalPayment> listAllByPage(Pageable pageable) {
        return additionalPaymentDao.findAll(pageable);
    }
}

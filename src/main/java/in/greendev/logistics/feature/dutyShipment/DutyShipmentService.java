package in.greendev.logistics.feature.dutyShipment;

import in.greendev.logistics.model.DutyShipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DutyShipmentService implements IDutyShipmentService {

    private final IDutyShipmentDao dutyShipmentDao;

    public DutyShipmentService(IDutyShipmentDao dutyShipmentDao) {
        this.dutyShipmentDao = dutyShipmentDao;
    }

    @Override
    public List<DutyShipment> findAll() {
        return dutyShipmentDao.findAll();
    }

    @Override
    public DutyShipment getOne(Long id) {
        return dutyShipmentDao.getOne(id);
    }

    @Override
    public void delete(DutyShipment dutyShipment) {
        dutyShipmentDao.delete(dutyShipment);
    }

    @Override
    public void save(DutyShipment dutyShipment) {
        dutyShipmentDao.save(dutyShipment);
    }

    @Override
    public void deleteById(Long id) {
        dutyShipmentDao.delete(id);
    }

    @Override
    public Page<DutyShipment> listAllByPage(Pageable pageable) {
        return dutyShipmentDao.findAll(pageable);
    }
}

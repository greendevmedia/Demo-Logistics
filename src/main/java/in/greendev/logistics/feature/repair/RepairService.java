package in.greendev.logistics.feature.repair;

import in.greendev.logistics.model.Repair;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RepairService implements IRepairService {

    private final IRepairDao repairDao;

    public RepairService(IRepairDao repairDao) {
        this.repairDao = repairDao;
    }

    @Override
    public List<Repair> findAll() {
        return repairDao.findAll();
    }

    @Override
    public Repair getOne(Long id) {
        return repairDao.getOne(id);
    }

    @Override
    public void delete(Repair repair) {
        repairDao.delete(repair);
    }

    @Override
    public void save(Repair repair) {
        repairDao.save(repair);
    }

    @Override
    public void deleteById(Long id) {
        repairDao.delete(id);
    }

    @Override
    public Page<Repair> listAllByPage(Pageable pageable) {
        return repairDao.findAll(pageable);

    }
}

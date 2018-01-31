package in.greendev.logistics.feature.refueling;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.greendev.logistics.model.Refueling;

@Service
@Transactional
public class RefuelingService implements IRefuelingService {

	private final IRefuelingDao refuelingDao;

	public RefuelingService(IRefuelingDao refuelingDao) {
		this.refuelingDao = refuelingDao;
	}

	@Override
	public List<Refueling> findAll() {
		return refuelingDao.findAll();
	}

	@Override
	public Refueling getOne(Long id) {
		return refuelingDao.getOne(id);
	}

	@Override
	public void delete(Refueling refueling) {
		refuelingDao.delete(refueling);
	}

	@Override
	public void save(Refueling refueling) {
		refuelingDao.save(refueling);
	}

	@Override
	public void deleteById(Long id) {
		refuelingDao.delete(id);
	}

	@Override
	public Page<Refueling> listAllByPage(Pageable pageable) {
		return refuelingDao.findAll(pageable);
	}
}

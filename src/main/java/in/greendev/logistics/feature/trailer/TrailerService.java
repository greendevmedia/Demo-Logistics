package in.greendev.logistics.feature.trailer;

import in.greendev.logistics.model.Trailer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrailerService implements ITrailerService {

    private final ITrailerDao trailerDao;

    public TrailerService(ITrailerDao trailerDao) {
        this.trailerDao = trailerDao;
    }

    @Override
    public List<Trailer> findAll() {
        return trailerDao.findAll();
    }

    @Override
    public Trailer getOne(Long id) {
        return trailerDao.getOne(id);
    }

    @Override
    public void delete(Trailer trailer) {
        trailerDao.delete(trailer);
    }

    @Override
    public void save(Trailer trailer) {
        trailerDao.save(trailer);
    }

    @Override
    public void deleteById(Long id) {
        trailerDao.delete(id);
    }

    @Override
    public Page<Trailer> listAllByPage(Pageable pageable) {
        return trailerDao.findAll(pageable);
    }
}

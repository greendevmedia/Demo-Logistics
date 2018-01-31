package in.greendev.logistics.feature.trailer;

import in.greendev.logistics.model.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrailerDao extends JpaRepository<Trailer, Long> {

}

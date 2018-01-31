package in.greendev.logistics.feature.repair;

import in.greendev.logistics.model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepairDao extends JpaRepository<Repair, Long> {
}

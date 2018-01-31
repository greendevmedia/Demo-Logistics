package in.greendev.logistics.feature.dutyShipment;

import in.greendev.logistics.model.DutyShipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDutyShipmentDao extends JpaRepository<DutyShipment, Long> {
}

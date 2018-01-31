package in.greendev.logistics.feature.additionalPaymentName;

import in.greendev.logistics.model.AdditionalPaymentName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdditionalPaymentNameDao extends JpaRepository<AdditionalPaymentName, Long> {
}

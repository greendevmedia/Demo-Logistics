package in.greendev.logistics.feature.additionalPayment;

import in.greendev.logistics.model.AdditionalPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdditionalPaymentDao  extends JpaRepository<AdditionalPayment, Long>{
}

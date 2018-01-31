package in.greendev.logistics.feature.currency;

import in.greendev.logistics.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICurrencyDao extends JpaRepository<Currency, Long> {
}

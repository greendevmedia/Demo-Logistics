package in.greendev.logistics.feature.refueling;

import org.springframework.data.jpa.repository.JpaRepository;

import in.greendev.logistics.model.Refueling;

public interface IRefuelingDao extends JpaRepository<Refueling, Long> {

}

package in.greendev.logistics.feature.shipment;

import in.greendev.logistics.model.Shipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import java.util.List;

public interface IShipmentDao extends JpaRepository<Shipment, Long> {

    @Query("SELECT s FROM Shipment s WHERE s.shipmentNumber = :number OR s.salesOrder = :number")
    List<Shipment> getShipmentsByShipmentNumberSalesOrder(@Param("number") final Long number);

    @Query("SELECT s FROM Shipment s WHERE  LOWER(s.place) like LOWER(CONCAT('%', :word, '%')) OR LOWER(s.name) like LOWER(CONCAT('%', :word, '%'))")
    List<Shipment> getShipmentsFromSearchByWord(@Param("word") final String word);

    @Query("SELECT s FROM Shipment s INNER JOIN s.customers c WHERE c.customerName = :customerName AND (s.shipmentNumber = :number OR s.salesOrder = :number)")
    List<Shipment> getShipmentsByShipmentNumberSalesOrderAndCustomerName(@Param("number") final Long number, @Param("customerName") final String customerName);

    @Query("SELECT s FROM Shipment s INNER JOIN s.customers c WHERE c.customerName = :customerName")
    Page<Shipment> listAllByPageForCustomerByName(Pageable pageable, final @Param("customerName") String customerName);

}

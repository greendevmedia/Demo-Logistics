package in.greendev.logistics.feature.shipment;

import in.greendev.logistics.model.Shipment;
import in.greendev.logistics.model.mappers.ShipmentForCustomer;
import in.greendev.logistics.model.mappers.ShipmentForDriver;
import in.greendev.logistics.model.mappers.ShipmentForPublican;
import in.greendev.logistics.service.ICrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


import java.util.List;

public interface IShipmentService extends ICrudService<Shipment> {

    List<Shipment> getShipmentsByShipmentNumberSalesOrder(Long number);

    List<ShipmentForCustomer> getShipmentsByShipmentNumberSalesOrderAndCustomerName(Long number,String customerName);

    List<Shipment> getShipmentsFromSearchByWord(String word);

    Page<ShipmentForCustomer> listAllByPageForCustomerByName(Pageable pageable, String customerName);



}

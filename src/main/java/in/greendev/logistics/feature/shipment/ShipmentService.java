package in.greendev.logistics.feature.shipment;

import in.greendev.logistics.model.Shipment;
import in.greendev.logistics.model.mappers.ShipmentForCustomer;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ShipmentService implements IShipmentService {

    private final IShipmentDao shipmentDao;


    public ShipmentService(IShipmentDao shipmentDao) {
        this.shipmentDao = shipmentDao;
    }

    @Override
    public List<Shipment> findAll() {
        return shipmentDao.findAll();
    }

    @Override
    public Shipment getOne(Long id) {
        return shipmentDao.getOne(id);
    }

    @Override
    public List<Shipment> getShipmentsFromSearchByWord(String word){
        return shipmentDao.getShipmentsFromSearchByWord(word);
    }

    @Override
    public List<Shipment> getShipmentsByShipmentNumberSalesOrder(Long number) {
        List<Shipment> shipments = shipmentDao.getShipmentsByShipmentNumberSalesOrder(number);
        return shipments;
    }

    @Override
    public List<ShipmentForCustomer> getShipmentsByShipmentNumberSalesOrderAndCustomerName(Long number, String customerName) {
        ModelMapper modelMapper = new ModelMapper();
        List<ShipmentForCustomer> shipmentsForCustomer = new ArrayList<>();
        List<Shipment> shipments = shipmentDao.getShipmentsByShipmentNumberSalesOrderAndCustomerName(number, customerName);
        for (Shipment shipment : shipments) {
            shipmentsForCustomer.add(modelMapper.map(shipment, ShipmentForCustomer.class));
        }
        return shipmentsForCustomer;
    }

    @Override
    public void delete(Shipment shipment) {
        shipmentDao.delete(shipment);
    }

    @Override
    public void save(Shipment shipment) {
        shipmentDao.save(shipment);
    }

    @Override
    public void deleteById(Long id) {
        shipmentDao.delete(id);
    }

    private final Sort SORT = new Sort(Sort.Direction.DESC, "id");

    @Override
    public Page<Shipment> listAllByPage(Pageable pageable) {
        Pageable pageableSort = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), this.SORT);
        return shipmentDao.findAll(pageableSort);
    }


    public Page<ShipmentForCustomer> listAllByPageForCustomerByName(Pageable pageable, String customerName) {
        ModelMapper modelMapper = new ModelMapper();
        Pageable pageableSort = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), this.SORT);
        Page<Shipment> shipments = shipmentDao.listAllByPageForCustomerByName(pageableSort, customerName);
        List<ShipmentForCustomer> shipmentForCustomers = new ArrayList<>();
        for (Shipment shipment : shipments) {
            shipmentForCustomers.add(modelMapper.map(shipment, ShipmentForCustomer.class));
        }
        Page<ShipmentForCustomer> shipmentForCustomersPage = new PageImpl<ShipmentForCustomer>(shipmentForCustomers, pageableSort, shipments.getTotalElements());
        return shipmentForCustomersPage;
    }


}

package in.greendev.logistics.model.mappers;

import in.greendev.logistics.model.DutyShipment;

import java.time.LocalDate;

public class ShipmentForPublican {

    private Long id;

    private LocalDate loadingDate;

    private LocalDate unloadingDate;

    private Long shipmentNumber;

    private Long orderNumber;

    private Long salesOrder;

    private double weightKg;

    private double capacityLtr;

    private String name;

    private String place;

    private String dutyShipmentNumber;

    private DutyShipment dutyShipment;

    public ShipmentForPublican() {
    }

    public ShipmentForPublican(Long id, LocalDate loadingDate, LocalDate unloadingDate, Long shipmentNumber, Long orderNumber, Long salesOrder, double weightKg, double capacityLtr, String name, String place, String dutyShipmentNumber, DutyShipment dutyShipment) {
        this.id = id;
        this.loadingDate = loadingDate;
        this.unloadingDate = unloadingDate;
        this.shipmentNumber = shipmentNumber;
        this.orderNumber = orderNumber;
        this.salesOrder = salesOrder;
        this.weightKg = weightKg;
        this.capacityLtr = capacityLtr;
        this.name = name;
        this.place = place;
        this.dutyShipmentNumber = dutyShipmentNumber;
        this.dutyShipment = dutyShipment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLoadingDate() {
        return loadingDate;
    }

    public void setLoadingDate(LocalDate loadingDate) {
        this.loadingDate = loadingDate;
    }

    public LocalDate getUnloadingDate() {
        return unloadingDate;
    }

    public void setUnloadingDate(LocalDate unloadingDate) {
        this.unloadingDate = unloadingDate;
    }

    public Long getShipmentNumber() {
        return shipmentNumber;
    }

    public void setShipmentNumber(Long shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(Long salesOrder) {
        this.salesOrder = salesOrder;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public double getCapacityLtr() {
        return capacityLtr;
    }

    public void setCapacityLtr(double capacityLtr) {
        this.capacityLtr = capacityLtr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDutyShipmentNumber() {
        return dutyShipmentNumber;
    }

    public void setDutyShipmentNumber(String dutyShipmentNumber) {
        this.dutyShipmentNumber = dutyShipmentNumber;
    }

    public DutyShipment getDutyShipment() {
        return dutyShipment;
    }

    public void setDutyShipment(DutyShipment dutyShipment) {
        this.dutyShipment = dutyShipment;
    }
}

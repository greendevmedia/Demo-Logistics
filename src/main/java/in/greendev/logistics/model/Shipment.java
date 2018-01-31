package in.greendev.logistics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Shipment {

    @GeneratedValue
    @Id
    private Long id;

    private LocalDate loadingDate;

    private LocalDate unloadingDate;

    @ManyToMany
    private List<Driver> drivers;

    private Long documentNumber;

    @Column(unique = true)
    private Long shipmentNumber;

    private Long salesOrder;

    @ElementCollection
    @OrderColumn
    @Column(nullable = false)
    private List<String> scanLinks = new ArrayList<String>();

    private double weightKg;

    private double capacityLtr;

    private String name;

    private String place;

    @ManyToMany
    private List<Customer> customers;

    @OneToOne
    private DutyShipment dutyShipment;

    private String dutyShipmentNumber;

    public Shipment() {

    }

    public Shipment(Long id, LocalDate loadingDate, LocalDate unloadingDate, List<Driver> drivers, Long documentNumber, Long shipmentNumber, Long salesOrder, List<String> scanLinks, double weightKg, double capacityLtr, String name, String place, List<Customer> customers, DutyShipment dutyShipment, String dutyShipmentNumber) {
        this.id = id;
        this.loadingDate = loadingDate;
        this.unloadingDate = unloadingDate;
        this.drivers = drivers;
        this.documentNumber = documentNumber;
        this.shipmentNumber = shipmentNumber;
        this.salesOrder = salesOrder;
        this.scanLinks = scanLinks;
        this.weightKg = weightKg;
        this.capacityLtr = capacityLtr;
        this.name = name;
        this.place = place;
        this.customers = customers;
        this.dutyShipment = dutyShipment;
        this.dutyShipmentNumber = dutyShipmentNumber;
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

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public Long getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Long getShipmentNumber() {
        return shipmentNumber;
    }

    public void setShipmentNumber(Long shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
    }

    public Long getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(Long salesOrder) {
        this.salesOrder = salesOrder;
    }

    public List<String> getScanLinks() {
        return scanLinks;
    }

    public void setScanLinks(List<String> scanLinks) {
        this.scanLinks = scanLinks;
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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public DutyShipment getDutyShipment() {
        return dutyShipment;
    }

    public void setDutyShipment(DutyShipment dutyShipment) {
        this.dutyShipment = dutyShipment;
    }

    public String getDutyShipmentNumber() {
        return dutyShipmentNumber;
    }

    public void setDutyShipmentNumber(String dutyShipmentNumber) {
        this.dutyShipmentNumber = dutyShipmentNumber;
    }
}


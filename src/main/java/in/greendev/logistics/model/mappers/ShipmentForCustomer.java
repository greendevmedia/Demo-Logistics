package in.greendev.logistics.model.mappers;


import java.time.LocalDate;
import java.util.List;

public class ShipmentForCustomer {

    private Long id;

    private LocalDate loadingDate;

    private LocalDate unloadingDate;

    private Long documentNumber;

    private Long shipmentNumber;

    private Long salesOrder;

    private List<String> scanLinks;

    private double weightKg;

    private double capacityLtr;

    private String name;

    private String place;

    public ShipmentForCustomer() {
    }

    public ShipmentForCustomer(Long id, LocalDate loadingDate, LocalDate unloadingDate, Long documentNumber, Long shipmentNumber, Long salesOrder, List<String> scanLinks, double weightKg, double capacityLtr, String name, String place) {
        this.id = id;
        this.loadingDate = loadingDate;
        this.unloadingDate = unloadingDate;
        this.documentNumber = documentNumber;
        this.shipmentNumber = shipmentNumber;
        this.salesOrder = salesOrder;
        this.scanLinks = scanLinks;
        this.weightKg = weightKg;
        this.capacityLtr = capacityLtr;
        this.name = name;
        this.place = place;
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
}

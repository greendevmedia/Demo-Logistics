package in.greendev.logistics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Repair {

    @GeneratedValue
    @Id
    private Long id;

    @NotNull
    private LocalDate repairDate;

    @NotNull
    @Min(0)
    private double counter;

    @NotNull
    private double price;

    @NotBlank
    private String repairType;

    @NotBlank
    private String driverName;

    @NotBlank
    private String carShopAddress;

    @OneToOne
    private Car car;

    @OneToOne
    private Trailer trailer;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ActivityType activityType;


    private String vehicalCheck;

    public Repair() {
    }

    public Repair(Long id, LocalDate repairDate, double counter, double price, String repairType, String driverName, String carShopAddress, Car car, Trailer trailer, ActivityType activityType, String vehicalCheck) {
        this.id = id;
        this.repairDate = repairDate;
        this.counter = counter;
        this.price = price;
        this.repairType = repairType;
        this.driverName = driverName;
        this.carShopAddress = carShopAddress;
        this.car = car;
        this.trailer = trailer;
        this.activityType = activityType;
        this.vehicalCheck = vehicalCheck;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(LocalDate repairDate) {
        this.repairDate = repairDate;
    }

    public double getCounter() {
        return counter;
    }

    public void setCounter(double counter) {
        this.counter = counter;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCarShopAddress() {
        return carShopAddress;
    }

    public void setCarShopAddress(String carShopAddress) {
        this.carShopAddress = carShopAddress;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public String getVehicalCheck() {
        return vehicalCheck;
    }

    public void setVehicalCheck(String vehicalCheck) {
        this.vehicalCheck = vehicalCheck;
    }
}

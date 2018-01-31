package in.greendev.logistics.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Refueling {

    @GeneratedValue
    @Id
    private Long id;

    @NotNull
    private LocalDate refuelingDate;

    @NotNull
    @Min(0)
    private double counter;

    @NotNull
    private double quantity;

    @NotNull
    private double price;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @NotBlank
    private String driverName;

    @NotNull
    @OneToOne
    private Car car;

    @NotNull
    @OneToOne
    private Currency currency;

    private String warningNote;

    private double adBlueQuantity;

    private double adBluePrice;

    public Refueling() {
    }

    public Refueling(Long id, LocalDate refuelingDate, double counter, double quantity, double price, PaymentType paymentType,
                     String driverName, Car car, Currency currency, String warningNote,
                     double adBlueQuantity, double adBluePrice) {
        this.id = id;
        this.refuelingDate = refuelingDate;
        this.counter = counter;
        this.quantity = quantity;
        this.price = price;
        this.paymentType = paymentType;
        this.driverName = driverName;
        this.car = car;
        this.currency = currency;
        this.warningNote = warningNote;
        this.adBlueQuantity = adBlueQuantity;
        this.adBluePrice = adBluePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getRefuelingDate() {
        return refuelingDate;
    }

    public void setRefuelingDate(LocalDate refuelingDate) {
        this.refuelingDate = refuelingDate;
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

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getWarningNote() {
        return warningNote;
    }

    public void setWarningNote(String warningNote) {
        this.warningNote = warningNote;
    }

    public double getAdBlueQuantity() {
        return adBlueQuantity;
    }

    public void setAdBlueQuantity(double adBlueQuantity) {
        this.adBlueQuantity = adBlueQuantity;
    }

    public double getAdBluePrice() {
        return adBluePrice;
    }

    public void setAdBluePrice(double adBluePrice) {
        this.adBluePrice = adBluePrice;
    }
}

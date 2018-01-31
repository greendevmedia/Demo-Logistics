package in.greendev.logistics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class AdditionalPayment {

    @GeneratedValue
    @Id
    private Long id;

    @NotNull
    private LocalDate paymentDay;

    @NotNull
    @OneToOne
    private AdditionalPaymentName paymentName;

    @NotNull
    private double totalPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @NotNull
    @OneToOne
    private Currency currency;

    @NotBlank
    private String driverName;

    @NotNull
    @OneToOne
    private Car car;

    public AdditionalPayment(){
    }

    public AdditionalPayment(Long id, LocalDate paymentDay, AdditionalPaymentName paymentName, double totalPrice, PaymentType paymentType, Currency currency, String driverName, Car car) {
        this.id = id;
        this.paymentDay = paymentDay;
        this.totalPrice = totalPrice;
        this.paymentType = paymentType;
        this.paymentName = paymentName;
        this.currency = currency;
        this.driverName = driverName;
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(LocalDate paymentDay) {
        this.paymentDay = paymentDay;
    }

    public AdditionalPaymentName getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(AdditionalPaymentName paymentName) {
        this.paymentName = paymentName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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
}

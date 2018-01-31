package in.greendev.logistics.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class AdditionalPaymentName {

    @GeneratedValue
    @Id
    private Long id;

    @NotBlank
    private String paymentName;


    public AdditionalPaymentName() {
    }

    public AdditionalPaymentName(Long id, String paymentName) {
        this.id = id;
        this.paymentName = paymentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
}

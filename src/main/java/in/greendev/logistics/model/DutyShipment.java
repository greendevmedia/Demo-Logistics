package in.greendev.logistics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class DutyShipment {

    @Id
    @GeneratedValue
    private Long id;

    private String dutyType;

    public DutyShipment() {
    }

    public DutyShipment(Long id, String dutyShipmentNumber) {
        this.id = id;
        this.dutyType = dutyType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDutyType() {
        return dutyType;
    }

    public void setDutyType(String dutyType) {
        this.dutyType = dutyType;
    }
}

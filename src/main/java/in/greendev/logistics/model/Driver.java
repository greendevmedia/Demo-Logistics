package in.greendev.logistics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Driver {

    @Id
    @GeneratedValue
    private Long id;

    private String driverName;

    public Driver() {
    }

    public Driver(Long id, String driverName) {
        this.id = id;
        this.driverName = driverName;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

}

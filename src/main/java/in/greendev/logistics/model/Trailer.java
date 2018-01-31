package in.greendev.logistics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Trailer extends  Vehical {

    public Trailer() {
    }

    public Trailer(Long id, String name) {
        super(id, name);
    }
}

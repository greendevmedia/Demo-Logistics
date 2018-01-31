package in.greendev.logistics.model;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Car extends Vehical {

	public Car() {
	}

	public Car(Long id, String name) {
		super(id, name);
	}

}

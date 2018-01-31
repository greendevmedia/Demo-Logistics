package in.greendev.logistics.feature.refueling;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.greendev.logistics.model.Refueling;

@RestController
@RequestMapping("/driver/api/v1/refuelings")
public class RefuelingApi {

	private final IRefuelingService refuelingService;

	public RefuelingApi(IRefuelingService refuelingService) {
		this.refuelingService = refuelingService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list() {
		final List<Refueling> refuelings = refuelingService.findAll();
		return new ResponseEntity<>(refuelings, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
		final Refueling refueling = refuelingService.getOne(id);
		return new ResponseEntity<>(refueling, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody final Refueling refueling) {
		refuelingService.save(refueling);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody final Refueling refueling) {
		refuelingService.save(refueling);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
		refuelingService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value="/refuelings-limit",method=RequestMethod.GET)
	Page<Refueling> list(Pageable pageable){
		final Page<Refueling> refuelings = refuelingService.listAllByPage(pageable);
		return refuelings;
	}

}

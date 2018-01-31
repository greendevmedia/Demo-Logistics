package in.greendev.logistics.feature.dutyShipment;

import in.greendev.logistics.model.DutyShipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver/api/v1/duty-shipments")
public class DutyShipmentApi {

    private final IDutyShipmentService dutyShipmentService;

    public DutyShipmentApi(IDutyShipmentService dutyShipmentService) {
        this.dutyShipmentService = dutyShipmentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> list() {
        final List<DutyShipment> dutyShipments = dutyShipmentService.findAll();
        return new ResponseEntity<>(dutyShipments, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
        final DutyShipment dutyShipment = dutyShipmentService.getOne(id);
        return new ResponseEntity<>(dutyShipment, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody final DutyShipment dutyShipment) {
        dutyShipmentService.save(dutyShipment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody final DutyShipment dutyShipment) {
        dutyShipmentService.save(dutyShipment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
        dutyShipmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/duty-shipments-limit",method=RequestMethod.GET)
    Page<DutyShipment> list(Pageable pageable){
        final Page<DutyShipment> dutyShipments = dutyShipmentService.listAllByPage(pageable);
        return dutyShipments;
    }
}

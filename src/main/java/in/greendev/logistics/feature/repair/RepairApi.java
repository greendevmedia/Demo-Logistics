package in.greendev.logistics.feature.repair;

import in.greendev.logistics.model.Repair;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver/api/v1/repairs")
public class RepairApi {

    private final IRepairService repairService;

    public RepairApi(IRepairService repairService) {
        this.repairService = repairService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> list() {
        final List<Repair> repairs = repairService.findAll();
        return new ResponseEntity<>(repairs, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
        final Repair repair = repairService.getOne(id);
        return new ResponseEntity<>(repair, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody final Repair repair) {
        repairService.save(repair);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody final Repair repair) {
        repairService.save(repair);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
        repairService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/refuelings-limit",method=RequestMethod.GET)
    Page<Repair> list(Pageable pageable){
        final Page<Repair> repairs = repairService.listAllByPage(pageable);
        return repairs;
    }
}

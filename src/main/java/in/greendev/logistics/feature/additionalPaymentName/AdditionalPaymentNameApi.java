package in.greendev.logistics.feature.additionalPaymentName;

import in.greendev.logistics.model.AdditionalPaymentName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver/api/v1/payments-name")
public class AdditionalPaymentNameApi {

    private final IAdditionalPaymentNameService additionalPaymentNameService;

    public AdditionalPaymentNameApi(IAdditionalPaymentNameService additionalPaymentNameService){
        this.additionalPaymentNameService = additionalPaymentNameService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> list() {
        final List<AdditionalPaymentName> additionalPaymentNames = additionalPaymentNameService.findAll();
        return new ResponseEntity<>(additionalPaymentNames, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
        final AdditionalPaymentName additionalPaymentName = additionalPaymentNameService.getOne(id);
        return new ResponseEntity<>(additionalPaymentName, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody final AdditionalPaymentName additionalPaymentName) {
        additionalPaymentNameService.save(additionalPaymentName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody final AdditionalPaymentName additionalPaymentName) {
        additionalPaymentNameService.save(additionalPaymentName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
        additionalPaymentNameService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/addition-payment-name-limit",method=RequestMethod.GET)
    Page<AdditionalPaymentName> list(Pageable pageable){
        final Page<AdditionalPaymentName> additionalPaymentNames = additionalPaymentNameService.listAllByPage(pageable);
        return additionalPaymentNames;
    }


}

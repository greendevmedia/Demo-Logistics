package in.greendev.logistics.feature.additionalPayment;

        import in.greendev.logistics.model.AdditionalPayment;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/driver/api/v1/additional-payments")
public class AdditionalPaymentApi {

    private final IAdditionalPaymentService additionalPaymentService;

    public AdditionalPaymentApi(IAdditionalPaymentService additionalPaymentService) {
        this.additionalPaymentService = additionalPaymentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> list() {
        final List<AdditionalPayment> additionalPayments = additionalPaymentService.findAll();
        return new ResponseEntity<>(additionalPayments, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
        final AdditionalPayment additionalPayment = additionalPaymentService.getOne(id);
        return new ResponseEntity<>(additionalPayment, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody final AdditionalPayment additionalPayment) {
        additionalPaymentService.save(additionalPayment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody final AdditionalPayment additionalPayment) {
        additionalPaymentService.save(additionalPayment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
        additionalPaymentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/additional-payment-limit", method = RequestMethod.GET)
    Page<AdditionalPayment> list(Pageable pageable) {
        final Page<AdditionalPayment> additionalPayments = additionalPaymentService.listAllByPage(pageable);
        return additionalPayments;
    }
}

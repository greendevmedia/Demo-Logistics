package in.greendev.logistics.feature.currency;

import in.greendev.logistics.model.Car;
import in.greendev.logistics.model.Currency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager/api/v1/currencies")
public class CurrencyApi {

    private final ICurrencyService currencyService;

    public CurrencyApi(ICurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> list() {
        final List<Currency> currencies = currencyService.findAll();
        return new ResponseEntity<>(currencies, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
        final Currency currency = currencyService.getOne(id);
        return new ResponseEntity<>(currency, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody final Currency currency) {
        currencyService.save(currency);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody final Currency currency) {
        currencyService.save(currency);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
        currencyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/currencies-limit",method=RequestMethod.GET)
    Page<Currency> list(Pageable pageable){
        final Page<Currency> currencies = currencyService.listAllByPage(pageable);
        return currencies;
    }
}

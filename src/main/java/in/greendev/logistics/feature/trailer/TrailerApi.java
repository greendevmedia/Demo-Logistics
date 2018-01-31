package in.greendev.logistics.feature.trailer;

import in.greendev.logistics.model.Trailer;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/manager/api/v1/trailers")
public class TrailerApi {

    private final ITrailerService trailerService;

    public TrailerApi(ITrailerService trailerService) {
        this.trailerService = trailerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> list() {
        final List<Trailer> trailers = trailerService.findAll();
        return new ResponseEntity<>(trailers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
        final Trailer trailer = trailerService.getOne(id);
        return new ResponseEntity<>(trailer, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody final Trailer trailer) {
        trailerService.save(trailer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody final Trailer trailer) {
        trailerService.save(trailer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
        trailerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/cars-limit",method=RequestMethod.GET)
    Page<Trailer> list(Pageable pageable){
        final Page<Trailer> trailers = trailerService.listAllByPage(pageable);
        return trailers;
    }
}

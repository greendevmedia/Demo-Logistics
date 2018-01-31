package in.greendev.logistics.feature.shipment;

import in.greendev.logistics.model.Shipment;
import in.greendev.logistics.model.mappers.ShipmentForCustomer;
import in.greendev.logistics.model.mappers.ShipmentForDriver;
import in.greendev.logistics.model.mappers.ShipmentForPublican;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = {"https://demo.zielinskimateusz.pl", "http://localhost:4200"})
@RestController
public class ShipmentApi {

    private final IShipmentService shipmentService;

    public ShipmentApi(IShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @RequestMapping(value = "/driver/api/v1/shipments", method = RequestMethod.GET)
    public ResponseEntity<?> list() {
        final List<Shipment> shipments = shipmentService.findAll();
        return new ResponseEntity<>(shipments, HttpStatus.OK);
    }

    @RequestMapping(value = "/driver/api/v1/shipments/ship/{number}", method = RequestMethod.GET)
    public ResponseEntity<?> byShipmentNumberSalesOrder(@PathVariable("number") final Long number) {
        final List<Shipment> shipments = shipmentService.getShipmentsByShipmentNumberSalesOrder(number);
        HttpStatus httpStatus = HttpStatus.OK;
        if (shipments.size() == 0) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(shipments, httpStatus);
    }

    @RequestMapping(value = "/customer-one/api/v1/shipments/{customerName}/{number}", method = RequestMethod.GET)
    public ResponseEntity<?> getShipmentsByShipmentNumberSalesOrderAndCustomerName(@PathVariable("number") final Long number, @PathVariable("customerName") final String customerName) {
        final List<ShipmentForCustomer> shipmentsForCustomer = shipmentService.getShipmentsByShipmentNumberSalesOrderAndCustomerName(number, customerName);
        HttpStatus httpStatus = HttpStatus.OK;
        if (shipmentsForCustomer.size() == 0) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(shipmentsForCustomer, httpStatus);
    }

    @RequestMapping(value = "/driver/api/v1/shipments/search/{word}", method = RequestMethod.GET)
    public ResponseEntity<?> byWordSearch(@PathVariable("word") final String word) {
        final List<Shipment> shipments = shipmentService.getShipmentsFromSearchByWord(word);
        HttpStatus httpStatus = HttpStatus.OK;
        if (shipments.size() == 0) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(shipments, httpStatus);
    }


    @RequestMapping(value = "/driver/api/v1/shipments", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody final Shipment shipment) {
        shipmentService.save(shipment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/driver/api/v1/shipments", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody final Shipment shipment) {
        shipmentService.save(shipment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/driver/api/v1/shipments/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
        shipmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/driver/api/v1/shipments/shipments-limit", method = RequestMethod.GET)
    Page<Shipment> list(Pageable pageable) {
        final Page<Shipment> shipmentPage = shipmentService.listAllByPage(pageable);
        return shipmentPage;
    }


    @RequestMapping(value = "/customer-all/api/v1/shipments/{customerName}/shipments-limit", method = RequestMethod.GET)
    Page<ShipmentForCustomer> listForCustomer(Pageable pageable, @PathVariable("customerName") String customerName) {
        final Page<ShipmentForCustomer> shipmentPage = shipmentService.listAllByPageForCustomerByName(pageable, customerName);
        return shipmentPage;
    }

    private static String UPLOADED_FOLDER = "/usr/home/mateusz/demoAppScans/";


    private LocalDate date;

    @RequestMapping(value = "/driver/api/v1/shipments/upload", method = RequestMethod.POST)
    public ResponseEntity<?> singleFileUpload(MultipartFile file) {

        Path path = null;
        long time = System.currentTimeMillis();
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            path = Paths.get(UPLOADED_FOLDER + time + "_" + file.getOriginalFilename());
            Files.write(path, bytes);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(time + "_" + file.getOriginalFilename(), HttpStatus.OK);
    }


    @RequestMapping(value = "/driver/api/v1/shipments/download/{name:.+}", method = RequestMethod.GET)
    public ResponseEntity<Resource> singleFileDownloadDriver(@PathVariable("name") final String name) throws IOException {
        System.out.println(name);

        File file2Upload = new File(this.UPLOADED_FOLDER + name);
        Path path = Paths.get(this.UPLOADED_FOLDER + name);

        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));


        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Access-Control-Allow-Origin", "https://demo.zielinskimateusz.pl");


        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file2Upload.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }


    @RequestMapping(value = "/customer-one/api/v1/shipments/download/{name:.+}", method = RequestMethod.GET)
    public ResponseEntity<Resource> singleFileDownload(@PathVariable("name") final String name) throws IOException {
        System.out.println(name);

        File file2Upload = new File(this.UPLOADED_FOLDER + name);
        Path path = Paths.get(this.UPLOADED_FOLDER + name);

        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));


        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Access-Control-Allow-Origin", "https://demo.zielinskimateusz.pl");


        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file2Upload.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }


}

package mr.quran.pulaar.quranpulaar.controller;

import mr.quran.pulaar.quranpulaar.model.Vente;
import mr.quran.pulaar.quranpulaar.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/quran/ventes")
public class VenteController {

    @Autowired
    VenteService venteService;

    @GetMapping("/{code}")
    public ResponseEntity<Vente> findVenteByCode(@PathVariable Integer code) {
        return ResponseEntity.status(HttpStatus.OK).body(venteService.findVenteByCode(code));
    }

    @GetMapping("/byPhoneNumber/{phoneNumber}")
    public ResponseEntity<List<Vente>> findVenteByPhoneNumber(@PathVariable Integer phoneNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(venteService.findVenteByPhoneNumber(phoneNumber));
    }

    @GetMapping("/byPhoneUID/{uid}")
    public ResponseEntity<Vente> byPhoneUID(@PathVariable String uid) {
        return ResponseEntity.status(HttpStatus.OK).body(venteService.findByDeviceInfoModelUniqueId(uid));
    }

    @PostMapping
    public ResponseEntity<Vente> save(@RequestBody Vente vente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(venteService.save(vente));
    }

    @GetMapping
    public ResponseEntity<List<Vente>> findAllVentes() {
        return ResponseEntity.status(HttpStatus.OK).body(venteService.findAllVentes());
    }

    @GetMapping("/reinitialiseUsedByCode/{code}")
    public ResponseEntity<Vente> reinitialiseUsedByCode(@PathVariable Integer code) {
        return ResponseEntity.status(HttpStatus.OK).body(venteService.reinitialiseUsedByCode(code));
    }
}







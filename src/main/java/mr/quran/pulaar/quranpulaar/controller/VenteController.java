package mr.quran.pulaar.quranpulaar.controller;

import lombok.extern.slf4j.Slf4j;
import mr.quran.pulaar.quranpulaar.model.Vente;
import mr.quran.pulaar.quranpulaar.model.dto.VenteDTO;
import mr.quran.pulaar.quranpulaar.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/quran/ventes")
@Slf4j

public class VenteController {

    @Autowired
    VenteService venteService;

    @GetMapping("/{code}")
    public ResponseEntity<VenteDTO> findVenteByCode(@PathVariable Integer code) {
        return ResponseEntity.status(HttpStatus.OK).body(venteService.findVenteByCode(code));
    }

    @GetMapping("/byPhoneNumber/{phoneNumber}")
    public ResponseEntity<VenteDTO> findVenteByPhoneNumber(@PathVariable String phoneNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(venteService.findVenteByPhoneNumber(phoneNumber));
    }

    @GetMapping("/byPhoneUID/{uid}")
    public ResponseEntity<VenteDTO> byPhoneUID(@PathVariable String uid) {
        return ResponseEntity.status(HttpStatus.OK).body(venteService.findByDeviceInfoModelUniqueId(uid));
    }

    @PostMapping
    public ResponseEntity<VenteDTO> save(@RequestBody VenteDTO vente) {
        VenteDTO dbVente = null;
        try {
            dbVente = venteService.save(vente);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(dbVente);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(dbVente);
    }

    @GetMapping
    public ResponseEntity<List<VenteDTO>> findAllVentes() {
        return ResponseEntity.status(HttpStatus.OK).body(venteService.findAllVentes());
    }

    @GetMapping("/reinitialiseUsedByCode/{code}")
    public ResponseEntity<VenteDTO> reinitialiseUsedByCode(@PathVariable Integer code) {
        return ResponseEntity.status(HttpStatus.OK).body(venteService.reinitialiseUsedByCode(code));
    }
}







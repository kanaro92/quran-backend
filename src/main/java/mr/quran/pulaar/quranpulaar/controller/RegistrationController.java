package mr.quran.pulaar.quranpulaar.controller;

import mr.quran.pulaar.quranpulaar.model.RegistrationInfo;
import mr.quran.pulaar.quranpulaar.model.Vente;
import mr.quran.pulaar.quranpulaar.service.RegistrationService;
import mr.quran.pulaar.quranpulaar.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/quran/registration")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<Vente> registerPhone(@RequestBody RegistrationInfo registrationInfo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.registerPhone(registrationInfo));
    }

    @GetMapping("/{uid}")
    public ResponseEntity<Vente> registerPhoneAfterUninstall(@PathVariable String uid) {
        return ResponseEntity.status(HttpStatus.OK).body(registrationService.registerPhoneAfterUninstall(uid));
    }
}







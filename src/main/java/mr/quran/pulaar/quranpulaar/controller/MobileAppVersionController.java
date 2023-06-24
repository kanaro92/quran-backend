package mr.quran.pulaar.quranpulaar.controller;

import mr.quran.pulaar.quranpulaar.model.MobileAppVersion;
import mr.quran.pulaar.quranpulaar.service.MobileAppVersionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/quran/mobile-app-version")
public class MobileAppVersionController {

    private final MobileAppVersionService mobileAppVersionService;

    public MobileAppVersionController(MobileAppVersionService mobileAppVersionService) {
        this.mobileAppVersionService = mobileAppVersionService;
    }

    @GetMapping
    public ResponseEntity<MobileAppVersion> getVersion() {
        return ResponseEntity.status(HttpStatus.OK).body(mobileAppVersionService.getVersion());
    }
}


package mr.quran.pulaar.quranpulaar.controller;

import mr.quran.pulaar.quranpulaar.model.DeviceInfoModel;
import mr.quran.pulaar.quranpulaar.model.Vente;
import mr.quran.pulaar.quranpulaar.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/quran/devices")
public class DeviceInfoController {

    @Autowired
    DeviceInfoService deviceInfoService;

    @GetMapping("/{uid}")
    public ResponseEntity<Boolean> isPhoneUIDValid(@PathVariable String uid) {
        return ResponseEntity.status(HttpStatus.OK).body(deviceInfoService.isPhoneUIDValid(uid));
    }

    @GetMapping
    public ResponseEntity<List<DeviceInfoModel>> findAllDevices() {
        return ResponseEntity.status(HttpStatus.OK).body(deviceInfoService.findAllDevices());
    }
}







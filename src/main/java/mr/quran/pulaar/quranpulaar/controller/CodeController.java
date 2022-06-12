package mr.quran.pulaar.quranpulaar.controller;

import mr.quran.pulaar.quranpulaar.model.Code;
import mr.quran.pulaar.quranpulaar.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/quran/codes")
public class CodeController {

    @Autowired
    CodeService codeService;

    @GetMapping("/{code}")
    public ResponseEntity<Code> checkCode(@PathVariable Integer code) {
        return ResponseEntity.status(HttpStatus.OK).body(codeService.checkCode(code));
    }

    @PostMapping
    public ResponseEntity<List<Code>> saveCodes(@RequestBody List<Integer> codes) {
        return ResponseEntity.status(HttpStatus.CREATED).body(codeService.saveCodes(codes));
    }

    @GetMapping("/generateCode")
    public ResponseEntity<Code> generateCode() {
        return ResponseEntity.status(HttpStatus.OK).body(codeService.generateCode());
    }
}


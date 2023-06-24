package mr.quran.pulaar.quranpulaar.controller;

import lombok.extern.slf4j.Slf4j;
import mr.quran.pulaar.quranpulaar.model.LoginRequest;
import mr.quran.pulaar.quranpulaar.model.dto.AppUserDTO;
import mr.quran.pulaar.quranpulaar.service.AppUserService;
import mr.quran.pulaar.quranpulaar.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/quran")
@Slf4j
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/token")
    public ResponseEntity<AppUserDTO> token(@RequestBody LoginRequest userLogin) throws AuthenticationException {
        AppUserDTO userDTO = null;
        try {
            userDTO = authService.authenticate(userLogin);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(userDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

}

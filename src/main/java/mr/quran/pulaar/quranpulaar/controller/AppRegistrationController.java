package mr.quran.pulaar.quranpulaar.controller;

import lombok.AllArgsConstructor;
import mr.quran.pulaar.quranpulaar.registration.RegistrationRequest;
import mr.quran.pulaar.quranpulaar.service.AppRegistrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/quran/app-registration")
@AllArgsConstructor
public class AppRegistrationController {

//    private final AppRegistrationService registrationService;
//
//    @PostMapping
//    public String register(@RequestBody RegistrationRequest request) {
//        return registrationService.register(request);
//    }
//
//    @GetMapping(path = "/confirm")
//    public String confirm(@RequestParam("token") String token) {
//        return registrationService.confirmToken(token);
//    }

}

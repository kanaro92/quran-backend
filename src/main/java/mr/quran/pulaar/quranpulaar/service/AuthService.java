package mr.quran.pulaar.quranpulaar.service;

import mr.quran.pulaar.quranpulaar.mapper.AppUserMapper;
import mr.quran.pulaar.quranpulaar.model.AppUser;
import mr.quran.pulaar.quranpulaar.model.LoginRequest;
import mr.quran.pulaar.quranpulaar.model.dto.AppUserDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final JwtEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final AppUserMapper appUserMapper;

    public AuthService(JwtEncoder encoder, AuthenticationManager authenticationManager, AppUserMapper appUserMapper) {
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
        this.appUserMapper = appUserMapper;
    }

    public AppUserDTO authenticate(LoginRequest userLogin) {
        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
        AppUserDTO userDTO = this.appUserMapper.appUserToDTO((AppUser) authentication.getPrincipal());
        String token = this.generateToken(authentication);
        userDTO.setToken(token);
        return userDTO;
    }

    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}

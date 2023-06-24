package mr.quran.pulaar.quranpulaar.mapper;

import mr.quran.pulaar.quranpulaar.model.AppUser;
import mr.quran.pulaar.quranpulaar.model.dto.AppUserDTO;
import org.springframework.stereotype.Component;

@Component
public class AppUserMapper {

    public AppUserDTO appUserToDTO(AppUser appUser) {
        if(appUser == null) {
            return null;
        }
        return AppUserDTO.builder()
                .id(appUser.getId())
                .firstName(appUser.getFirstName())
                .lastName(appUser.getLastName())
                .email(appUser.getEmail())
                .build();
    }

    public AppUser dtoToAppUser(AppUserDTO appUserDTO) {
        if(appUserDTO == null) {
            return null;
        }
        return AppUser.builder()
                .id(appUserDTO.getId())
                .firstName(appUserDTO.getFirstName())
                .lastName(appUserDTO.getLastName())
                .email(appUserDTO.getEmail())
                .build();
    }
}

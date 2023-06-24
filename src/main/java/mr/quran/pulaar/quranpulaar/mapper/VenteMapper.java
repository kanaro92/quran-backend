package mr.quran.pulaar.quranpulaar.mapper;

import mr.quran.pulaar.quranpulaar.model.Vente;
import mr.quran.pulaar.quranpulaar.model.dto.VenteDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VenteMapper {

    private final CodeMapper codeMapper;
    private final DeviceInfoModelMapper deviceInfoModelMapper;
    private final AppUserMapper appUserMapper;

    public VenteMapper(CodeMapper codeMapper, DeviceInfoModelMapper deviceInfoModelMapper, AppUserMapper appUserMapper) {
        this.codeMapper = codeMapper;
        this.deviceInfoModelMapper = deviceInfoModelMapper;
        this.appUserMapper = appUserMapper;
    }

    public VenteDTO venteToDTO(Vente vente) {
        if(vente == null) {
            return null;
        }
        return VenteDTO.builder()
                .id(vente.getId())
                .name(vente.getName())
                .phone(vente.getPhone())
                .country(vente.getCountry())
                .mruPrice(vente.getMruPrice())
                .cfaPrice(vente.getCfaPrice())
                .dollarPrice(vente.getDollarPrice())
                .code(this.codeMapper.codeToDTO(vente.getCode()))
                .deviceInfoModel(this.deviceInfoModelMapper.deviceInfoModelToDTO(vente.getDeviceInfoModel()))
                .createdBy(appUserMapper.appUserToDTO(vente.getCreatedBy()))
                .updatedBy(appUserMapper.appUserToDTO(vente.getUpdatedBy()))
                .createdDate(vente.getCreatedDate())
                .updatedDate(vente.getUpdatedDate())
                .isUsed(vente.isUsed())
                .build();
    }

    public Vente dtoToVente(VenteDTO vente) {
        if(vente == null) {
            return null;
        }
        return Vente.builder()
                .id(vente.getId())
                .name(vente.getName())
                .phone(vente.getPhone())
                .country(vente.getCountry())
                .mruPrice(vente.getMruPrice())
                .cfaPrice(vente.getCfaPrice())
                .dollarPrice(vente.getDollarPrice())
                .code(this.codeMapper.dtoToCode(vente.getCode()))
                .deviceInfoModel(this.deviceInfoModelMapper.dtoToDeviceInfoModel(vente.getDeviceInfoModel()))
                .createdBy(appUserMapper.dtoToAppUser(vente.getCreatedBy()))
                .updatedBy(appUserMapper.dtoToAppUser(vente.getUpdatedBy()))
                .createdDate(vente.getCreatedDate())
                .updatedDate(vente.getUpdatedDate())
                .isUsed(vente.isUsed())
                .build();
    }

    public List<VenteDTO> listVenteToDTO(List<Vente> list) {
        return list.stream().map(this::venteToDTO).collect(Collectors.toList());
    }
}

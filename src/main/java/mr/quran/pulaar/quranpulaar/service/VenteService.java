package mr.quran.pulaar.quranpulaar.service;

import mr.quran.pulaar.quranpulaar.mapper.VenteMapper;
import mr.quran.pulaar.quranpulaar.model.DeviceInfoModel;
import mr.quran.pulaar.quranpulaar.model.Vente;
import mr.quran.pulaar.quranpulaar.model.dto.VenteDTO;
import mr.quran.pulaar.quranpulaar.repository.VenteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VenteService {
    private final VenteRepository venteRepository;
    private final DeviceInfoService deviceInfoService;
    private final CodeService codeService;
    private final VenteMapper venteMapper;

    public VenteService(VenteRepository venteRepository, DeviceInfoService deviceInfoService, CodeService codeService, VenteMapper venteMapper) {
        this.venteRepository = venteRepository;
        this.deviceInfoService = deviceInfoService;
        this.codeService = codeService;
        this.venteMapper = venteMapper;
    }

    public VenteDTO findVenteByCode(Integer code) {
        return venteMapper.venteToDTO(venteRepository.findByCode_Code(code));
    }

    public VenteDTO findVenteByPhoneNumber(String phoneNumber) {
        return venteMapper.venteToDTO(venteRepository.findByPhone(phoneNumber));
    }

    public VenteDTO findByCodeAndUsedIsFalse(Integer code) {
        return venteMapper.venteToDTO((venteRepository.findByCode_CodeAndIsUsedIsFalse(code)));
    }

    public VenteDTO save(VenteDTO vente) {
        if(vente.getId() == null){
            vente.setCreatedDate(LocalDateTime.now());
            vente.setUpdatedDate(LocalDateTime.now());
            if(findVenteByPhoneNumber(vente.getPhone()) != null) {
                throw new RuntimeException("Phone number already exists");
            }
            vente.setCode(codeService.generateCode());
        } else {
            vente.setUpdatedDate(LocalDateTime.now());
        }
        return venteMapper.venteToDTO(venteRepository.save(venteMapper.dtoToVente(vente)));
    }

    public Vente update(Vente vente) {
        vente.setUpdatedDate(LocalDateTime.now());
        return venteRepository.save(vente);
    }

    public List<VenteDTO> findAllVentes() {
        return venteMapper.listVenteToDTO(venteRepository.findAll());
    }

    public List<VenteDTO> findAllByCreatedBy(Long id) {
        return venteMapper.listVenteToDTO(venteRepository.findAllByCreatedBy_Id(id));
    }

    public VenteDTO findByDeviceInfoModelUniqueId(String uid) {
        return venteMapper.venteToDTO(venteRepository.findByDeviceInfoModel_UniqueId(uid));
    }

    public VenteDTO reinitialiseUsedByCode(Integer code) {
        Vente vente = venteRepository.findByCode_Code(code);
        if (vente != null) {
            vente.setUsed(false);
            DeviceInfoModel device = vente.getDeviceInfoModel();
            vente.setDeviceInfoModel(null);
            //remove device if exists
            if(device != null){
                deviceInfoService.deleteDevice(device);
            }
            return venteMapper.venteToDTO(venteRepository.save(vente));
        }
        return null;
    }
}

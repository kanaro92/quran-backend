package mr.quran.pulaar.quranpulaar.service;

import mr.quran.pulaar.quranpulaar.model.DeviceInfoModel;
import mr.quran.pulaar.quranpulaar.model.Vente;
import mr.quran.pulaar.quranpulaar.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VenteService {
    @Autowired
    VenteRepository venteRepository;
    @Autowired
    DeviceInfoService deviceInfoService;

    public Vente findVenteByCode(Integer code) {
        return venteRepository.findByCode_Code(code);
    }

    public List<Vente> findVenteByPhoneNumber(Integer phoneNumber) {
        return venteRepository.findByPhone(phoneNumber);
    }

    public Vente findByCodeAndUsedIsFalse(Integer code) {
        return venteRepository.findByCode_CodeAndIsUsedIsFalse(code);
    }

    public Vente save(Vente vente) {
        if(vente.getId() == null){
            vente.setCreatedDate(LocalDateTime.now());
            vente.setUpdatedDate(LocalDateTime.now());
        } else {
            vente.setUpdatedDate(LocalDateTime.now());
        }
        return venteRepository.save(vente);
    }

    public Vente update(Vente vente) {
        vente.setUpdatedDate(LocalDateTime.now());
        return venteRepository.save(vente);
    }

    public List<Vente> findAllVentes() {
        return venteRepository.findAll();
    }

    public Vente findByDeviceInfoModelUniqueId(String uid) {
        return venteRepository.findByDeviceInfoModel_UniqueId(uid);
    }

    public Vente reinitialiseUsedByCode(Integer code) {
        Vente vente = venteRepository.findByCode_Code(code);
        if (vente != null) {
            vente.setUsed(false);
            DeviceInfoModel device = vente.getDeviceInfoModel();
            vente.setDeviceInfoModel(null);
            //remove device if exists
            if(device != null){
                deviceInfoService.deleteDevice(device);
            }
            return save(vente);
        }
        return null;
    }
}

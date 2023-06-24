package mr.quran.pulaar.quranpulaar.service;

import mr.quran.pulaar.quranpulaar.mapper.DeviceInfoModelMapper;
import mr.quran.pulaar.quranpulaar.mapper.VenteMapper;
import mr.quran.pulaar.quranpulaar.model.DeviceInfoModel;
import mr.quran.pulaar.quranpulaar.model.RegistrationInfo;
import mr.quran.pulaar.quranpulaar.model.dto.VenteDTO;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final VenteService venteService;
    private final DeviceInfoService deviceInfoService;
    private final DeviceInfoModelMapper deviceInfoModelMapper;
    private final VenteMapper venteMapper;

    public RegistrationService(VenteService venteService, DeviceInfoService deviceInfoService, DeviceInfoModelMapper deviceInfoModelMapper, VenteMapper venteMapper) {
        this.venteService = venteService;
        this.deviceInfoService = deviceInfoService;
        this.deviceInfoModelMapper = deviceInfoModelMapper;
        this.venteMapper = venteMapper;
    }

    public VenteDTO registerPhone(RegistrationInfo registrationInfo) {
        VenteDTO vente = venteService.findByCodeAndUsedIsFalse(registrationInfo.getCode());
        if (vente != null) {
            vente.setUsed(true);
            DeviceInfoModel oldDevice = deviceInfoModelMapper.dtoToDeviceInfoModel(vente.getDeviceInfoModel());
            DeviceInfoModel device = deviceInfoService.save(registrationInfo.getDeviceInfoModel());
            vente.setDeviceInfoModel(deviceInfoModelMapper.deviceInfoModelToDTO(device));
            venteService.save(vente);
            //remove old device if exists
            if (oldDevice != null) {
                deviceInfoService.deleteDevice(oldDevice);
            }
        }
        /*
        if (vente != null) {
            vente.setUsed(true);
            DeviceInfoModel device = deviceInfoService.findByUniqueId(registrationInfo.getDeviceInfoModel().getUniqueId());
            if (device == null) {
                device = deviceInfoService.save(registrationInfo.getDeviceInfoModel());
                DeviceInfoModel oldDevice = vente.getDeviceInfoModel();
                vente.setDeviceInfoModel(device);
                venteService.update(vente);
                //remove old device if exists
                if(oldDevice != null){
                    deviceInfoService.deleteDevice(oldDevice);
                }
            } else {
                registrationInfo.getDeviceInfoModel().setId(device.getId());
                deviceInfoService.save(registrationInfo.getDeviceInfoModel());
            }
        }*/
        return vente;
    }

    public VenteDTO registerPhoneAfterUninstall(String uid) {
        if (deviceInfoService.isPhoneUIDValid(uid)) {
            return venteService.findByDeviceInfoModelUniqueId(uid);
        }
        return null;
    }
}

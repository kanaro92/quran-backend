package mr.quran.pulaar.quranpulaar.service;

import mr.quran.pulaar.quranpulaar.model.DeviceInfoModel;
import mr.quran.pulaar.quranpulaar.model.RegistrationInfo;
import mr.quran.pulaar.quranpulaar.model.Vente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    VenteService venteService;
    @Autowired
    DeviceInfoService deviceInfoService;

    public Vente registerPhone(RegistrationInfo registrationInfo) {
        Vente vente = venteService.findByCodeAndUsedIsFalse(registrationInfo.getCode());
        if (vente != null) {
            vente.setUsed(true);
            DeviceInfoModel oldDevice = vente.getDeviceInfoModel();
            DeviceInfoModel device = deviceInfoService.save(registrationInfo.getDeviceInfoModel());
            vente.setDeviceInfoModel(device);
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

    public Vente registerPhoneAfterUninstall(String uid) {
        if (deviceInfoService.isPhoneUIDValid(uid)) {
            return venteService.findByDeviceInfoModelUniqueId(uid);
        }
        return null;
    }
}

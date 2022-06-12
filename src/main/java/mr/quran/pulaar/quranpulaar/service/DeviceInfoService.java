package mr.quran.pulaar.quranpulaar.service;

import mr.quran.pulaar.quranpulaar.model.Code;
import mr.quran.pulaar.quranpulaar.model.DeviceInfoModel;
import mr.quran.pulaar.quranpulaar.model.Vente;
import mr.quran.pulaar.quranpulaar.repository.CodeRepository;
import mr.quran.pulaar.quranpulaar.repository.DeviceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceInfoService {
    @Autowired
    DeviceInfoRepository deviceInfoRepository;

    public DeviceInfoModel findByUniqueId(String uniqueId) {
        return deviceInfoRepository.findByUniqueId(uniqueId);
    }

    public DeviceInfoModel save(DeviceInfoModel deviceInfoModel) {
        return deviceInfoRepository.save(deviceInfoModel);
    }

    public Boolean isPhoneUIDValid(String uid){
        DeviceInfoModel deviceInfoModel = deviceInfoRepository.findByUniqueId(uid);
        return deviceInfoModel != null;
    }

    public List<DeviceInfoModel> findAllDevices() {
        return deviceInfoRepository.findAll();
    }


    public void deleteDevice(DeviceInfoModel deviceInfoModel) {
        deviceInfoRepository.delete(deviceInfoModel);
    }
}

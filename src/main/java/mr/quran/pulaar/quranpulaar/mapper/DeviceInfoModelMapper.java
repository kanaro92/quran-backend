package mr.quran.pulaar.quranpulaar.mapper;

import mr.quran.pulaar.quranpulaar.model.DeviceInfoModel;
import mr.quran.pulaar.quranpulaar.model.dto.DeviceInfoModelDTO;
import org.springframework.stereotype.Component;

@Component
public class DeviceInfoModelMapper {

    public DeviceInfoModelDTO deviceInfoModelToDTO(DeviceInfoModel deviceInfoModel) {
        if(deviceInfoModel == null) {
            return null;
        }
        return DeviceInfoModelDTO.builder()
                .id(deviceInfoModel.getId())
                .uniqueId(deviceInfoModel.getUniqueId())
                .deviceName(deviceInfoModel.getDeviceName())
                .deviceModel(deviceInfoModel.getDeviceModel())
                .baseOs(deviceInfoModel.getBaseOs())
                .firstInstallTime(deviceInfoModel.getFirstInstallTime())
                .manufacturer(deviceInfoModel.getManufacturer())
                .build();
    }

    public DeviceInfoModel dtoToDeviceInfoModel(DeviceInfoModelDTO deviceInfoModel) {
        if(deviceInfoModel == null) {
            return null;
        }
        return DeviceInfoModel.builder()
                .id(deviceInfoModel.getId())
                .uniqueId(deviceInfoModel.getUniqueId())
                .deviceName(deviceInfoModel.getDeviceName())
                .deviceModel(deviceInfoModel.getDeviceModel())
                .baseOs(deviceInfoModel.getBaseOs())
                .firstInstallTime(deviceInfoModel.getFirstInstallTime())
                .manufacturer(deviceInfoModel.getManufacturer())
                .build();
    }
}

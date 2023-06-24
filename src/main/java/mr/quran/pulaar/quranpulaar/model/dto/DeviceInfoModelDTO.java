package mr.quran.pulaar.quranpulaar.model.dto;

import lombok.*;

import javax.persistence.*;


@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DeviceInfoModelDTO {
    private Long id;
    private String uniqueId;
    private String baseOs;
    private String deviceName;
    private String deviceModel;
    private String manufacturer;
    private String firstInstallTime;
}

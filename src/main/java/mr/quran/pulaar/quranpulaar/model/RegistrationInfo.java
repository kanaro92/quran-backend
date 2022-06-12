package mr.quran.pulaar.quranpulaar.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationInfo {
    private Integer code;
    private DeviceInfoModel deviceInfoModel;
}

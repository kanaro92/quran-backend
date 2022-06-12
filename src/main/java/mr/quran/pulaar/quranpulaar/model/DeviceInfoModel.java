package mr.quran.pulaar.quranpulaar.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class DeviceInfoModel {
    @SequenceGenerator(
            name = "device_sequence",
            sequenceName = "device_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "device_sequence"
    )
    private Long id;
    private String uniqueId;
    private String baseOs;
    private String deviceName;
    private String deviceModel;
    private String manufacturer;
    private String firstInstallTime;
}

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
public class MobileAppVersion {
    @SequenceGenerator(
            name = "app_version_sequence",
            sequenceName = "app_version_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "app_version_sequence"
    )
    private Long id;
    private String androidAppVersion;
    private String iosAppVersion;
}

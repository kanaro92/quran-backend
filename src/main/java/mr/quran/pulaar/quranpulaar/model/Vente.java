package mr.quran.pulaar.quranpulaar.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class Vente {
    @SequenceGenerator(
            name = "vente_sequence",
            sequenceName = "vente_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vente_sequence"
    )
    private Long id;
    private String name;
    private String phone;
    private String country;
    private Double mruPrice;
    private Double cfaPrice;
    private Double dollarPrice;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    @OneToOne
    private Code code;
    @OneToOne
    private DeviceInfoModel deviceInfoModel;
    @Column(columnDefinition = "boolean default false")
    private boolean isUsed;
    @OneToOne
    private AppUser createdBy;
    @OneToOne
    private AppUser updatedBy;
}

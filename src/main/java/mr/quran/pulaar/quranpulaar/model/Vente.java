package mr.quran.pulaar.quranpulaar.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
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
    private Long phone;
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

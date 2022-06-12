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
public class Code {
    @SequenceGenerator(
            name = "code_sequence",
            sequenceName = "code_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "code_sequence"
    )
    private Long id;
    private Integer code;
}

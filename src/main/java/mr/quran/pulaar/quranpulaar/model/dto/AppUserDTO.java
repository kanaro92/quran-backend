package mr.quran.pulaar.quranpulaar.model.dto;

import lombok.*;


@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AppUserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String token;

}

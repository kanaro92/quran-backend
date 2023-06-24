package mr.quran.pulaar.quranpulaar.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public final class LoginRequest {
    private String username;
    private String password;
}

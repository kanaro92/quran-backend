package mr.quran.pulaar.quranpulaar.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mr.quran.pulaar.quranpulaar.model.AppUser;
import mr.quran.pulaar.quranpulaar.model.Code;
import mr.quran.pulaar.quranpulaar.model.DeviceInfoModel;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VenteDTO {

    private Long id;
    private String name;
    private String phone;
    private String country;
    private Double mruPrice;
    private Double cfaPrice;
    private Double dollarPrice;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private CodeDTO code;
    private DeviceInfoModelDTO deviceInfoModel;
    private boolean isUsed;
    private AppUserDTO createdBy;
    private AppUserDTO updatedBy;

}

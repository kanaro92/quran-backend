package mr.quran.pulaar.quranpulaar.repository;

import mr.quran.pulaar.quranpulaar.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface VenteRepository
        extends JpaRepository<Vente, Long> {
    Vente findByCode_Code(Integer code);
    Vente findByPhone(String code);
    Vente findByCode_CodeAndIsUsedIsFalse(Integer code);
    Vente findByDeviceInfoModel_UniqueId(String uid);
}

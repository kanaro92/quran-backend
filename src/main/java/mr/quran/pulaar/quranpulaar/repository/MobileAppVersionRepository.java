package mr.quran.pulaar.quranpulaar.repository;

import mr.quran.pulaar.quranpulaar.model.MobileAppVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface MobileAppVersionRepository
        extends JpaRepository<MobileAppVersion, Long> {
}

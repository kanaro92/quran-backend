package mr.quran.pulaar.quranpulaar.service;

import mr.quran.pulaar.quranpulaar.model.MobileAppVersion;
import mr.quran.pulaar.quranpulaar.repository.MobileAppVersionRepository;
import org.springframework.stereotype.Service;

@Service
public class MobileAppVersionService {

    private final MobileAppVersionRepository mobileAppVersionRepository;

    public MobileAppVersionService(MobileAppVersionRepository mobileAppVersionRepository) {
        this.mobileAppVersionRepository = mobileAppVersionRepository;
    }

    public MobileAppVersion getVersion() {
        return mobileAppVersionRepository.findAll().stream().findFirst().orElse(null);
    }

}

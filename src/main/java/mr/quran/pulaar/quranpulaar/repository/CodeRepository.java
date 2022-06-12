package mr.quran.pulaar.quranpulaar.repository;

import mr.quran.pulaar.quranpulaar.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface CodeRepository
        extends JpaRepository<Code, Long> {

    Code findByCode(Integer code);
    //Code findByCodeIsNotIn(c)
    //Code findBy();
}

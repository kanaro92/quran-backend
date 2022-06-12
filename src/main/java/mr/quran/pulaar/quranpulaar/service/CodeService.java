package mr.quran.pulaar.quranpulaar.service;

import mr.quran.pulaar.quranpulaar.model.Code;
import mr.quran.pulaar.quranpulaar.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodeService {
    @Autowired
    CodeRepository codeRepository;

    public Code checkCode(Integer code) {
        return codeRepository.findByCode(code);
    }

    public List<Code> saveCodes(List<Integer> codes){
        List<Code> codeList = new ArrayList<>();
        codes.forEach(code -> {
            Code c = Code.builder().code(code).build();
            codeList.add(c);
        });

        return codeRepository.saveAll(codeList);
    }
    public Code generateCode() {
        return null;
    }

}

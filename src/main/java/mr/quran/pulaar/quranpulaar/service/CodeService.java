package mr.quran.pulaar.quranpulaar.service;

import mr.quran.pulaar.quranpulaar.mapper.CodeMapper;
import mr.quran.pulaar.quranpulaar.model.Code;
import mr.quran.pulaar.quranpulaar.model.Vente;
import mr.quran.pulaar.quranpulaar.model.dto.CodeDTO;
import mr.quran.pulaar.quranpulaar.repository.CodeRepository;
import mr.quran.pulaar.quranpulaar.repository.VenteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CodeService {

    private final CodeRepository codeRepository;
    private final VenteRepository venteService;
    private final CodeMapper codeMapper;

    public CodeService(CodeRepository codeRepository, VenteRepository venteService, CodeMapper codeMapper) {
        this.codeRepository = codeRepository;
        this.venteService = venteService;
        this.codeMapper = codeMapper;
    }

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
    public CodeDTO generateCode() {
        List<Code> codeList = codeRepository.findAll();
        List<Vente> venteList = venteService.findAll();
        List<Code> unUsedCodes = codeList.stream()
                .filter(
                        c -> !venteList.stream().
                                map(Vente::getCode)
                                .collect(Collectors.toList())
                                .contains(c)
                ).collect(Collectors.toList());
        Random rand = new Random();
        return codeMapper.codeToDTO(unUsedCodes.get(rand.nextInt(unUsedCodes.size())));
    }

}

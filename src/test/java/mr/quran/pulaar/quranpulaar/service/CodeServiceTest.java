package mr.quran.pulaar.quranpulaar.service;

import mr.quran.pulaar.quranpulaar.mapper.CodeMapper;
import mr.quran.pulaar.quranpulaar.model.Code;
import mr.quran.pulaar.quranpulaar.model.Vente;
import mr.quran.pulaar.quranpulaar.model.dto.CodeDTO;
import mr.quran.pulaar.quranpulaar.repository.CodeRepository;
import mr.quran.pulaar.quranpulaar.repository.VenteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CodeServiceTest {

    @InjectMocks
    private CodeService codeService;

    @Mock
    CodeRepository codeRepository;

    @Mock
    CodeMapper codeMapper;

    @Mock
    VenteRepository venteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSaveCodes() {
        //Given
        List<Integer> codes = Collections.singletonList(111111);
        List<Code> codeList = Collections.singletonList(
                Code.builder().code(111111).build()
        );

        when(codeRepository.saveAll(codeList)).thenReturn(codeList);

        //When
        List<Code> savedCodes = codeService.saveCodes(codes);

        //Then
        assertEquals(codeList.size(), savedCodes.size());
    }

    @Test
    void shouldGenerateCode() {
        //Given
        List<Code> codeList = Arrays.asList(
                Code.builder().code(222222).build(),
                Code.builder().code(333333).build()
        );
        List<Vente> venteList = Collections.singletonList(
                Vente.builder()
                        .name("Diallo")
                        .dollarPrice(20.0)
                        .code(Code.builder().code(222222).build())
                        .createdDate(LocalDateTime.now())
                        .build()
        );
        Code code = Code.builder().code(333333).build();
        CodeDTO codeDTO = CodeDTO.builder().code(333333).build();

        when(codeRepository.findAll()).thenReturn(codeList);
        when(venteRepository.findAll()).thenReturn(venteList);

        //When
        List<Code> unUsedCodes = codeList.stream()
                .filter(c -> !venteList.stream().map(Vente::getCode).collect(Collectors.toList()).contains(c))
                .collect(Collectors.toList());


        Random rand = new Random();
        when(codeMapper.codeToDTO(unUsedCodes.get(rand.nextInt(unUsedCodes.size())))).thenReturn(codeDTO);
        //Then
        assertEquals(unUsedCodes.size(), 1);
    }
}


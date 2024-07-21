package mr.quran.pulaar.quranpulaar.mapper;

import mr.quran.pulaar.quranpulaar.model.Code;
import mr.quran.pulaar.quranpulaar.model.dto.CodeDTO;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CodeMapperTest {

    private CodeMapper codeMapper;

    @BeforeEach
    void setUp() {
        System.out.println("Before each");
        codeMapper = new CodeMapper();
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all");
    }

    @Test
    void shouldMapCodeToDTO() {
        //Given
        Code code = Code.builder().id(1L).code(1111111).build();

        //When
        CodeDTO codeDTO = codeMapper.codeToDTO(code);

        //Then
        assertEquals(codeDTO.getId(), code.getId());
        assertEquals(codeDTO.getCode(), code.getCode());
    }

    @Test
    void should_throw_null_pointer_exception_when_code_is_null() {
        NullPointerException exp = assertThrows(NullPointerException.class, () -> codeMapper.codeToDTO(null));
    }

    @Test
    void dtoToCode() {
    }
}

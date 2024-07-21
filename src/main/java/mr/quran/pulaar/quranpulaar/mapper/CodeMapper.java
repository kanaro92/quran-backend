package mr.quran.pulaar.quranpulaar.mapper;

import mr.quran.pulaar.quranpulaar.model.Code;
import mr.quran.pulaar.quranpulaar.model.dto.CodeDTO;
import org.springframework.stereotype.Component;

@Component
public class CodeMapper {

    public CodeDTO codeToDTO(Code code) {
        if(code == null) {
            throw new NullPointerException("Code should not be null");
        }
        return CodeDTO.builder()
                .id(code.getId())
                .code(code.getCode())
                .build();
    }

    public Code dtoToCode(CodeDTO code) {
        if(code == null) {
            return null;
        }
        return Code.builder()
                .id(code.getId())
                .code(code.getCode())
                .build();
    }
}

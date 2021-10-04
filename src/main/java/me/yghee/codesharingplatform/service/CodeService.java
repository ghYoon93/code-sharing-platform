package me.yghee.codesharingplatform.service;

import me.yghee.codesharingplatform.domain.Code;
import me.yghee.codesharingplatform.domain.CodeNotFoundException;
import me.yghee.codesharingplatform.repository.CodeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CodeService {

    private final CodeRepository codeRepository;

    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public Code getCode(Long id) {

        return codeRepository.findById(id).orElseThrow(() -> new CodeNotFoundException(id));
    }

    public Code postCode(Code code) {
        code.setDate(LocalDateTime.now());
        return codeRepository.save(code);
    }



    public List<Code> getLatest() {
        return codeRepository.findTop10ByOrderByIdDesc();
    }
}

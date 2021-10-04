package me.yghee.codesharingplatform.service;

import me.yghee.codesharingplatform.domain.Code;
import me.yghee.codesharingplatform.repository.CodeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class CodeServiceTests {
    private CodeService codeService;

    @Mock
    private CodeRepository codeRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockCodeRepository();
        codeService = new CodeService(codeRepository);

    }

    private void mockCodeRepository() {
        List<Code> codes = new ArrayList<>();
        Code code = new Code("public static void...", "2021-10-01 00:00:00");
        codes.add(code);

        given(codeRepository.findById(1L)).willReturn(Optional.of(code));
    }

    @Test
    void getCode() {

        Code code = codeService.getCode(1L);

        assertThat(code.getCode()).isEqualTo("public static void...");
        assertThat(code.getDate()).isEqualTo("2021-10-01 00:00:00");
    }

    @Test
    void postCode() {
    }

    @Test
    void getLatest() {
    }
}
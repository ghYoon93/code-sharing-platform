package me.yghee.codesharingplatform.service;

import me.yghee.codesharingplatform.domain.Code;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CodeServiceTests {
    private CodeService codeService;

    @Mock
    private List<Optional<Code>> codes;

    @Mock
    private Deque<Code> latest = new ArrayDeque<>();

    void mockCodes() {

    }

    void mockLatest() {

    }

    @Test
    void getCode() {

        codeService.getCode(1);
    }

    @Test
    void postCode() {
    }

    @Test
    void getLatest() {
    }
}
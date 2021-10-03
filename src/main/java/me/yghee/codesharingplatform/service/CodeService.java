package me.yghee.codesharingplatform.service;

import me.yghee.codesharingplatform.domain.Code;
import me.yghee.codesharingplatform.domain.CodeNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CodeService {

    private List<Optional<Code>> codes = new ArrayList<>(Arrays.asList(Optional.of(new Code("public static void...", "2021-10-01 00:00:00"))));
    private Deque<Code> latest = new ArrayDeque<>();

    public Code getCode(int id) {

        return codes.get(id).orElseThrow(() -> new CodeNotFoundException(id));
    }

    public int postCode(Code code) {
        code.setDate(LocalDateTime.now());
        codes.add(Optional.of(code));
        updateLatest(code);
        return codes.size() - 1;
    }

    private void updateLatest(Code code) {
        if (latest.size() > 9) {
            latest.removeLast();
        }
        latest.addFirst(code);
    }

    public Deque<Code> getLatest() {
        return latest;
    }
}

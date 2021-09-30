package me.yghee.codesharingplatform;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CodeApiController {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String TEST_DATE = "2021-09-26 15:00:03";

    private static String codeSnippet = "public static void ...";

    private Code code = new Code(TEST_DATE, codeSnippet);
    private List<Code> codes = new ArrayList<>();


    @GetMapping("/api/code/{id}")
    public Code apiCode(@PathVariable int id) {
        return codes.get(id - 1);
    }

    @PostMapping("/api/code/new")
    public Code post(@RequestBody Code newCode) {
        newCode.setDate(LocalDateTime.now().format(FORMATTER));
        codes.add(newCode);
        CodeController.addCode(newCode);
        return this.code;
    }
}

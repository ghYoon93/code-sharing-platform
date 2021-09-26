package me.yghee.codesharingplatform;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class CodeApiController {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String TEST_DATE = "2021-09-26 15:00:03";

    private static String codeSnippet = "public static void ...";

    private Code code = new Code(TEST_DATE, codeSnippet);


    @GetMapping("/api/code")
    @ResponseBody
    public Code apiCode() {
        return code;
    }

    @ResponseBody
    @PostMapping("/api/code/new")
    public Code post(@RequestBody Code newCode) {
        System.out.println(newCode.getCode());
        newCode.setDate(LocalDateTime.now().format(FORMATTER));
        this.code = newCode;
        CodeController.setCode(this.code);
        return this.code;
    }
}

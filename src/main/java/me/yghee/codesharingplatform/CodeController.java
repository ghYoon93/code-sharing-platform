package me.yghee.codesharingplatform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CodeController {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String TEST_DATE = "2021-09-26 15:00:03";

    private static String codeSnippet = "public static void ...";

    private static Code code = new Code(TEST_DATE, codeSnippet);
    private static List<Code> codes = new ArrayList<>();


    @GetMapping(value = "/code")
    public String code(Model model) {
        model.addAttribute(code);

        return "code";
    }

    @GetMapping(value = "/code/new")
    public String create() {
        return "new";
    }

    public static void addCode(Code newCode) {
        codes.add(newCode);
    }
}

package me.yghee.codesharingplatform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CodeController {

    private static Code initialCode  = new Code("2021-10-01-00-00", "public static void...");
    private static List<Code> codes = new ArrayList<>(Arrays.asList(initialCode));

    @GetMapping(value = "/code/{id}")
    public String code(Model model, @PathVariable int id) {
        if (id >= codes.size()) {
            throw new IllegalArgumentException("There's no such code");
        }
        model.addAttribute(codes.get(id));
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

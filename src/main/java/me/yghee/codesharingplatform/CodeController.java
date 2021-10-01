package me.yghee.codesharingplatform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CodeController {

    private static List<Code> codes = new ArrayList<>();

    @GetMapping(value = "/code/{id}")
    public String code(Model model, @PathVariable int id) {
        model.addAttribute(codes.get(id - 1));
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

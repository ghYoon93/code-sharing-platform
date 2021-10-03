package me.yghee.codesharingplatform.controller;

import me.yghee.codesharingplatform.domain.Code;
import me.yghee.codesharingplatform.service.CodeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Deque;

@Controller
public class CodeController {

    private final CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(value = "/code/{id}")
    public String code(Model model, @PathVariable int id) {
        Code code = codeService.getCode(id);
        model.addAttribute(code);
        return "code";
    }

    @GetMapping("/code/new")
    public String create() {
        return "new";
    }

    @GetMapping("/code/latest")
    public String latest(Model model) {
        Deque<Code> codes = codeService.getLatest();
        model.addAttribute("codes", codes);
        return "latest";
    }
}

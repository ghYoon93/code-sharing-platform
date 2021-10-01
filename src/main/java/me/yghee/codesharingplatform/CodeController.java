package me.yghee.codesharingplatform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CodeController {

    private Codes codes = Codes.getInstance();

    @GetMapping(value = "/code/{id}")
    public String code(Model model, @PathVariable int id) {
        if (id >= codes.size()) {
            throw new IllegalArgumentException("There's no such code");
        }
        model.addAttribute(codes.get(id));
        return "code";
    }

    @GetMapping("/code/new")
    public String create() {
        return "new";
    }

    @GetMapping("/code/latest")
    public String latest(Model model) {
        List<Code> codes = this.codes.getLatest();
        model.addAttribute("codes", codes);
        return "latest";
    }
}

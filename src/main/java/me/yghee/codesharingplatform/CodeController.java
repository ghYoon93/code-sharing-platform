package me.yghee.codesharingplatform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/code/new")
    public String create() {
        return "new";
    }
}

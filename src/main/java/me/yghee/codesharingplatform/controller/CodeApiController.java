package me.yghee.codesharingplatform.controller;

import me.yghee.codesharingplatform.domain.Code;
import me.yghee.codesharingplatform.service.CodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CodeApiController {

    private final CodeService codeService;

    public CodeApiController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/api/code/{id}")
    public Code apiCode(@PathVariable Long id) {

        return codeService.getCode(id);
    }

    @PostMapping("/api/code/new")
    public String post(@RequestBody Code resource) {
        Code code = codeService.postCode(resource);


        return "{ \"id\" : \"" + code.getId() + "\" }";
    }

    @GetMapping("/api/code/latest")
    public List<Code> latest() {
        return codeService.getLatest();
    }
}

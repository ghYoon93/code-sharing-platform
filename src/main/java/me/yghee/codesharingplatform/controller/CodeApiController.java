package me.yghee.codesharingplatform.controller;

import me.yghee.codesharingplatform.domain.Code;
import me.yghee.codesharingplatform.service.CodeService;
import org.springframework.web.bind.annotation.*;

import java.util.Deque;

@RestController
public class CodeApiController {

    private final CodeService codeService;

    public CodeApiController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/api/code/{id}")
    public Code apiCode(@PathVariable int id) {

        return codeService.getCode(id);
    }

    @PostMapping("/api/code/new")
    public String post(@RequestBody Code resource) {
        long id = codeService.postCode(resource);


        return "{ \"id\" : \"" + id + "\" }";
    }

    @GetMapping("/api/code/latest")
    public Deque<Code> latest() {
        return codeService.getLatest();
    }
}

package me.yghee.codesharingplatform;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CodeApiController {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private List<Code> codes = new ArrayList<>();

    @GetMapping("/api/code/{id}")
    public ResponseEntity<?> apiCode(@PathVariable int id) {
        if (codes.size() == 0) {
            return ResponseEntity.badRequest().body("there's no code");
        }
        return ResponseEntity.ok(codes.get(id - 1));
    }

    @PostMapping("/api/code/new")
    public String post(@RequestBody Code newCode) {
        newCode.setDate(LocalDateTime.now().format(FORMATTER));
        codes.add(newCode);
        CodeController.addCode(newCode);
        return "{ \"id\" : \"" + codes.size() + "\" }";
    }
}

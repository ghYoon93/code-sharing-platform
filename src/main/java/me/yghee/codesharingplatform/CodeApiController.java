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

    private Codes codes = Codes.getInstance();

    @GetMapping("/api/code/{id}")
    public ResponseEntity<?> apiCode(@PathVariable int id) {
        if (id == codes.size()) {
            return ResponseEntity.badRequest().body("There's no such code");
        }
        return ResponseEntity.ok(codes.get(id));
    }

    @PostMapping("/api/code/new")
    public String post(@RequestBody Code newCode) {
        newCode.setDate(LocalDateTime.now().format(FORMATTER));

        return "{ \"id\" : \"" + codes.add(newCode) + "\" }";
    }
}

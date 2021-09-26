package me.yghee.codesharingplatform;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.format.DateTimeFormatter;

@RestController
public class CodeController {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String TEST_DATE = "2021-09-26 15:00:03";

    private static String codeSnippet = "public static void ...";

    private static Code code = new Code(TEST_DATE, codeSnippet);



    @GetMapping(value = "/code", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> code() {

        String html = getTemplate("/templates/code.html");
        System.out.println(html);
        html = html.replace("{date}", code.getDate());
        html = html.replace("{code_snippet}", code.getCode());
        return ResponseEntity.ok().body(html);
    }

    @GetMapping(value = "/code/new", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> create() {
        String html = getTemplate("/templates/new.html");
        return ResponseEntity.ok()
                .body(html);
    }

    private String getTemplate(String path) {
        try {
            File template = new ClassPathResource(path).getFile();
            return Files.readString(template.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return "x";
        }
    }

    public static void setCode(Code newCode) {
        code = newCode;
    }
}

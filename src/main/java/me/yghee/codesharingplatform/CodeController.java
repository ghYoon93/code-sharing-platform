package me.yghee.codesharingplatform;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class CodeController {
    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private Code code = new Code(LocalDateTime.now().format(FORMATTER), "");

    @GetMapping(value = "/code", produces = MediaType.TEXT_HTML_VALUE)
    public String code() {
        return "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Code</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <span id=\"load_date\">"+ code.getDate() +"</span>\n" +
                "<pre>\n" +
                code.getCode() +
                "</pre>\n" +
                "</body>\n" +
                "</html>";
    }

    @GetMapping(value = "/code/new", produces = MediaType.TEXT_HTML_VALUE)
    public String create() {
        return "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Create</title>\n" +
                "    <script>\n" +
                "      function send() {\n" +
                "      let object = {\n" +
                "          \"code\": document.getElementById(\"code_snippet\").value\n" +
                "      };\n" +
                "\n" +
                "      let json = JSON.stringify(object);\n" +
                "\n" +
                "      let xhr = new XMLHttpRequest();\n" +
                "      xhr.open(\"POST\", '/api/code/new', false)\n" +
                "      xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');\n" +
                "      xhr.send(json);\n" +
                "\n" +
                "      if (xhr.status == 200) {\n" +
                "        alert(\"Success!\");\n" +
                "      }\n" +
                "}\n" +
                "    </script>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <textarea id=\"code_snippet\" placeholder=\"// 코드 작성\"></textarea>\n" +
                "  <div>" +
                "    <button id=\"send_snippet\" type=\"submit\" onclick=\"send()\">Submit</button>\n" +
                "  </div>" +
                "</body>\n" +
                "</html>";
    }

    @GetMapping("/api/code")
    @ResponseBody
    public Code apiCode() {
        return code;
    }

    @ResponseBody
    @PostMapping("/api/code/new")
    public String post(@RequestBody Code code) {
        code.setDate(LocalDateTime.now().format(FORMATTER));
        this.code = code;
        return "{}";
    }

}

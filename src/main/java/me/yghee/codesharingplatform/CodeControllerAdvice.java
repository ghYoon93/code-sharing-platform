package me.yghee.codesharingplatform;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CodeControllerAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    public String noSuchCode() {
        return "new";
    }
}

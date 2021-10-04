package me.yghee.codesharingplatform.domain;

public class CodeNotFoundException extends RuntimeException {
    public CodeNotFoundException(Long id) {
        super("Could not find code "+id);
    }
}

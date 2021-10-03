package me.yghee.codesharingplatform.domain;

public class CodeNotFoundException extends RuntimeException {
    public CodeNotFoundException(int id) {
        super("Could not find code "+id);
    }
}

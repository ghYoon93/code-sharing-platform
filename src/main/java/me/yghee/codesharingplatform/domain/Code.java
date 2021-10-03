package me.yghee.codesharingplatform.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Code {

    private String code;
    private String date;
    public Code(String code) {
        this.code = code;
    }

    public Code(String code, String date) {
        this.code = code;
        this.date = date;
    }

    public Code() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

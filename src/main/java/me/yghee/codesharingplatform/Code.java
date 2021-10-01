package me.yghee.codesharingplatform;

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

    public void setDate(String date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

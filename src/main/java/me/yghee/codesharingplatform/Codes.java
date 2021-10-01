package me.yghee.codesharingplatform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codes {
    private static Codes codes = new Codes();
    private static List<Code> codeList = new ArrayList<>(Arrays.asList(new Code("2021-10-01-00-00", "public static void...")));

    public static Codes getInstance() {
        return codes;
    }

    public synchronized int add(Code code) {
        codeList.add(code);
        return codeList.size() - 1;
    }

    public synchronized int size() {
        return codeList.size();
    }

    public synchronized Code get(int id) {
        return codeList.get(id);
    }
}

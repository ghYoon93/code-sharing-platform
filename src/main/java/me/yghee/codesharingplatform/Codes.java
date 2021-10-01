package me.yghee.codesharingplatform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Codes {
    private static Codes codes = new Codes();
    private static List<Code> codeList = new ArrayList<>(Arrays.asList(new Code("public static void...", "2021-10-01 00:00:00")));

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

    public List<Code> getLatest() {
        List<Code> latest = new ArrayList<>();
        if (codeList.size() < 12) {
            latest = codeList.subList(1, codeList.size());
        } else {
            codeList.subList(codeList.size() - 2, codeList.size());
        }

        Collections.reverse(latest);

        return latest;
    }
}

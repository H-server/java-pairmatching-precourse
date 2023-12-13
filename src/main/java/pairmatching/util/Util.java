package pairmatching.util;

import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<String> splitByComma(String input) {
        return Arrays.asList(input.split(", "));
    }
}

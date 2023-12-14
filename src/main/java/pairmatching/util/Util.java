package pairmatching.util;

import java.util.Arrays;
import java.util.List;
import pairmatching.view.InputView;

public class Util {
    public static List<String> splitByComma(String input) {
        return Arrays.asList(input.split(", "));
    }
}

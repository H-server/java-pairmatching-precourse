package pairmatching.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<String> splitByComma(String input) {
        return Arrays.asList(input.split(", "));
    }

    public static List<String> readAllLines(String filePath) {
        List<String> names = null;
        try {
            names = readLinesFromFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }

    private static List<String> readLinesFromFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path);
    }
}

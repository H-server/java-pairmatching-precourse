package pairmatching.model;

import static pairmatching.util.Course.BACKEND;
import static pairmatching.util.Course.FRONTEND;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.util.Util;

public class PairMatch {
    public void setPair(String input) {
        List<String> courseLevelMission = Util.splitByComma(input);
        List<String> crewNames = getCrewNames(courseLevelMission.get(0));
        List<List<String>> pairResult = createPairs(crewNames);
        Map<List<String>, List<List<String>>> pairMatchResult = createPairMatchResult(courseLevelMission, pairResult);
        System.out.println(pairMatchResult);
    }

    private List<String> getCrewNames(String courseDescription) {
        if (FRONTEND.getDescription().equals(courseDescription)) {
            return readAllLines(FRONTEND.getFilePath());
        }
        if (BACKEND.getDescription().equals(courseDescription)) {
            return readAllLines(BACKEND.getFilePath());
        }
        return Collections.emptyList();
    }

    private List<List<String>> createPairs(List<String> crewNames) {
        List<String> shuffledCrew = Randoms.shuffle(crewNames);
        List<String> pair = new ArrayList<>();
        List<List<String>> pairResult = new ArrayList<>();
        for (String crew : shuffledCrew) {
            pair.add(crew);
            if (pair.size() == 2) {
                pairResult.add(new ArrayList<>(pair));
                pair.clear();
            }
        }
        if (!pair.isEmpty()) {
            pairResult.get(pairResult.size() - 1).addAll(pair);
        }
        return pairResult;
    } // 메서드 라인 줄이기

    private Map<List<String>, List<List<String>>> createPairMatchResult(List<String> courseLevelMission, List<List<String>> pairResult) {
        Map<List<String>, List<List<String>>> pairMatchResult = new HashMap<>();
        pairMatchResult.put(new ArrayList<>(courseLevelMission), new ArrayList<>(pairResult));
        return pairMatchResult;
    }

    private List<String> readAllLines(String filePath) {
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

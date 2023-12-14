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
    public void setPair(List<String> courseLevelMission) {


        // 이미 매칭한 결과가 있는지 확인
        PairResult.checkPairMatchResult(courseLevelMission);

        List<String> crewNames = getCrewNames(courseLevelMission.get(0));
        List<List<String>> pairResult = createPairs(crewNames);
        PairResult.addPairMatchResult(courseLevelMission, pairResult);

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
        // 같은 레벨에서 만난 적이 있는가? 3회까지 안 돼?
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

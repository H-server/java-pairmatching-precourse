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
import java.util.List;
import pairmatching.view.OutputView;

public class PairMatch {
    public void setPair(List<String> courseLevelMission) {
        // 이미 매칭한 결과가 있는지 확인
        PairResult.checkPairMatchResult(courseLevelMission);

        List<String> crewNames = getCrewNames(courseLevelMission.get(0));
        List<List<String>> pairResult = createUniquePairs(courseLevelMission, crewNames);
        PairResult.addPairMatchResult(courseLevelMission, pairResult);
    }

    private List<List<String>> createUniquePairs(List<String> courseLevelMission, List<String> crewNames) {
        int maxTries = 3;
        int count = 0;
        List<List<String>> pairResult;
        do {
            pairResult = createPairs(crewNames);
            count++;
        } while (count < maxTries && !PairResult.checkSameLevelUniquePair(courseLevelMission, pairResult));

        if (count == maxTries) {
            throw new IllegalStateException("[ERROR] 매칭 시도 횟수 초과했습니다.");
        }
        return pairResult;
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

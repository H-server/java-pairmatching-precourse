package pairmatching.model;

import static pairmatching.util.Course.BACKEND;
import static pairmatching.util.Course.FRONTEND;
import static pairmatching.util.Util.readAllLines;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairMatch {
    public void setPair(List<String> courseLevelMission) {
        List<String> crewNames = getCrewNames(courseLevelMission.get(0));
        List<List<String>> pairResult = createUniquePairs(courseLevelMission, crewNames);
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

    private List<List<String>> createPairs(List<String> crewNames) {
        List<String> pair = new ArrayList<>();
        List<List<String>> pairResult = new ArrayList<>();
        for (String crew : Randoms.shuffle(crewNames)) {
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
    }
}

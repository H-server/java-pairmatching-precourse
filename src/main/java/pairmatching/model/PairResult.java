package pairmatching.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pairmatching.view.OutputView;

public class PairResult {
    private static Map<List<String>, List<List<String>>> pairMatchResult = new HashMap<>();

    public static void addPairMatchResult(List<String> courseLevelMission, List<List<String>> pairResult) {
        pairMatchResult.put(new ArrayList<>(courseLevelMission), new ArrayList<>(pairResult));
        OutputView.printPairMatchResult(courseLevelMission);
    }

    public static boolean checkPairMatchResult(List<String> courseLevelMission){
        return pairMatchResult.containsKey(courseLevelMission);
    }

    public static List<List<String>> getPairResult(List<String> courseLevelMission) {
        return pairMatchResult.get(courseLevelMission);
    }

    public static boolean checkSameLevelUniquePair(List<String> courseLevelMission, List<List<String>> pairResult) {
        List<List<String>> matchingPairs;
        for (List<String> key : pairMatchResult.keySet()) {
            if (key.subList(0, 2).equals(courseLevelMission.subList(0, 2))) {
                matchingPairs = pairMatchResult.get(key);
                List<List<String>> commonElements = pairResult.stream()
                        .distinct()
                        .filter(matchingPairs::contains)
                        .collect(Collectors.toList());
                if (!commonElements.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void resetPairMatchResult() {
        pairMatchResult = new HashMap<>();
    }
}

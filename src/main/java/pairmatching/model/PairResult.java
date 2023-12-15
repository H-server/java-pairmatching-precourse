package pairmatching.model;

import java.util.ArrayList;
import java.util.Collections;
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
        return pairMatchResult.keySet().stream()
                .filter(key -> key.subList(0, 2).equals(courseLevelMission.subList(0, 2)))
                .anyMatch(key -> hasCommonPairs(pairMatchResult.get(key), pairResult));
    }

    private static boolean hasCommonPairs(List<List<String>> matchingPairs, List<List<String>> newPairs) {
        return Collections.disjoint(matchingPairs, newPairs);
    }

    public static void resetPairMatchResult() {
        pairMatchResult = new HashMap<>();
    }
}

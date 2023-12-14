package pairmatching.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairResult {
    private static Map<List<String>, List<List<String>>> pairMatchResult = new HashMap<>();

    public static void addPairMatchResult(List<String> courseLevelMission, List<List<String>> pairResult) {
        pairMatchResult.put(new ArrayList<>(courseLevelMission), new ArrayList<>(pairResult));
    }

    public static boolean checkPairMatchResult(List<String> courseLevelMission){
        return pairMatchResult.containsKey(courseLevelMission);
    }
}

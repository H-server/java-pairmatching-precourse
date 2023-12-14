package pairmatching.view;

import java.util.List;
import pairmatching.model.PairResult;
import pairmatching.util.Course;
import pairmatching.view.InputView.Level;
import pairmatching.view.InputView.Mission;

public class OutputView {
    private static final String REMATCHING_PROMPT = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";

    public static void printReMatchingPrompt() {
        System.out.println(REMATCHING_PROMPT);
    }

    public static void printCourseMission() {
        System.out.println("\n#############################################");
        System.out.println("과정: " + Course.BACKEND.getDescription() + " | " + Course.FRONTEND.getDescription());
        System.out.println("미션:");
        for (Level level : Level.values()) {
            System.out.println("  - " + level.getDescription() + ": " + getMissionsForLevel(level));
        }
        System.out.println("#############################################");
    }

    private static String getMissionsForLevel(Level level) {
        if (level.getMissions().length == 0) {
            return "";
        }

        StringBuilder missions = new StringBuilder();
        for (Mission mission : level.getMissions()) {
            missions.append(mission.getDescription()).append(" | ");
        }
        return missions.toString().replaceAll(" \\| $", "");  // 마지막에 추가된 " | " 제거
    }

    public static void printPairMatchResult(List<String> courseLevelMission) {
        System.out.println("\n페어 매칭 결과입니다.");
        for (List<String> pair : PairResult.getPairResult(courseLevelMission)) {
            System.out.println(String.join(" : ", pair));
        }
    }

    public static void printResetMessage() {
        System.out.println("\n초기화 되었습니다.");
    }
}

package pairmatching.util;

import java.util.List;

public class Validator {
    public static void validateSelectedFeature(String input) {
        if (!input.matches("[123Q]")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력값입니다. 1, 2, 3, Q 중 하나를 입력하세요.");
        }
    }

    public static void validateCourseLevelMission(List<String> input) {
        validateCourse(input.get(0));
        validateLevel(input.get(1));
        validateMission(input.get(2));
    }

    public static void validateCourse(String input) {
        for (Course course : Course.values()) {
            if (course.getDescription().equalsIgnoreCase(input)) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 코스입니다.");
    }

    public static void validateLevel(String input) {
        for (Level level : Level.values()) {
            if (level.getDescription().equalsIgnoreCase(input)) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 레벨입니다.");
    }

    public static void validateMission(String input) {
        for (Mission mission : Mission.values()) {
            if (mission.getDescription().equalsIgnoreCase(input)) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 미션입니다.");
    }
}

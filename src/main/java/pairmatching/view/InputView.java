package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.util.Course;
import pairmatching.util.Level;
import pairmatching.util.Mission;

public class InputView {
    private static final String PROMPT_MESSAGE = "\n기능을 선택하세요.";

    public enum Feature {
        PAIR_MATCHING("1. 페어 매칭"),
        PAIR_LOOKUP("2. 페어 조회"),
        PAIR_RESET("3. 페어 초기화"),
        EXIT("Q. 종료");

        private final String description;

        Feature(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static String readFeature() {
        System.out.println(PROMPT_MESSAGE);
        for (Feature feature : Feature.values()) {
            System.out.println(feature.getDescription());
        }
        return Console.readLine();
    }

    public static String readCourseLevelMission() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) " + Course.BACKEND.getDescription() + ", " + Level.LEVEL1.getDescription() + ", " + Mission.CAR_RACING.getDescription());
        return Console.readLine();
    }

    public static String readReMatching() {
        OutputView.printReMatchingPrompt();
        return Console.readLine();
    }
}

package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.util.Course;

public class InputView {
    private static final String PROMPT_MESSAGE = "기능을 선택하세요.";

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

    public enum Level {
        LEVEL1("레벨1", Mission.CAR_RACING, Mission.LOTTO, Mission.BASEBALL),
        LEVEL2("레벨2", Mission.CART, Mission.PAYMENT, Mission.SUBWAY),
        LEVEL3("레벨3"),
        LEVEL4("레벨4", Mission.PERFORMANCE, Mission.DEPLOYMENT),
        LEVEL5("레벨5");

        private final String description;
        private final Mission[] missions;

        Level(String description, Mission... missions) {
            this.description = description;
            this.missions = missions;
        }

        public String getDescription() {
            return description;
        }

        public Mission[] getMissions() {
            return missions;
        }
    }

    public enum Mission {
        CAR_RACING("자동차경주"),
        LOTTO("로또"),
        BASEBALL("숫자야구게임"),
        CART("장바구니"),
        PAYMENT("결제"),
        SUBWAY("지하철노선도"),
        PERFORMANCE("성능개선"),
        DEPLOYMENT("배포");

        private final String description;

        Mission(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static String readReMatching() {
        OutputView.printReMatchingPrompt();
        return Console.readLine();
    }
}

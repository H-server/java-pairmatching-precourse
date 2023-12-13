package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

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

    public static String readSelectedFeature() {
        System.out.println(PROMPT_MESSAGE);
        for (Feature feature : Feature.values()) {
            System.out.println(feature.getDescription());
        }
        return Console.readLine();
    }
}

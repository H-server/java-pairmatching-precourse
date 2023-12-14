package pairmatching.util;

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

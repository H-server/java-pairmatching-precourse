package pairmatching.util;

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

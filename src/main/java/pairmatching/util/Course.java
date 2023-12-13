package pairmatching.util;

public enum Course {
    BACKEND("백엔드", "src/main/resources/backend-crew.md"),
    FRONTEND("프론트엔드", "src/main/resources/frontend-crew.md");

    private final String description;
    private final String filePath;

    Course(String description, String filePath) {
        this.description = description;
        this.filePath = filePath;
    }

    public String getDescription() {
        return description;
    }

    public String getFilePath() {
        return filePath;
    }
}


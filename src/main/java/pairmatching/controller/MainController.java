package pairmatching.controller;

import pairmatching.view.InputView;

public class MainController {
    public void execute() {
        String selectedFeature = InputView.readFeature();
        if(selectedFeature.equals("1")) {
            matchPair();
        }
    }

    private void matchPair() {
        InputView.readCourseLevelMission();
    }
}

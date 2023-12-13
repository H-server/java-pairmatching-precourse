package pairmatching.controller;

import pairmatching.model.PairMatch;
import pairmatching.view.InputView;

public class MainController {
    public void execute() {
        String selectedFeature = InputView.readFeature();
        if(selectedFeature.equals("1")) {
            matchPair();
        }
    }

    private void matchPair() {
        PairMatch pairMatch = new PairMatch();
        pairMatch.setPair(InputView.readCourseLevelMission());
    }
}

package pairmatching.controller;

import pairmatching.model.PairResult;
import pairmatching.util.Validator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {
    public void execute() {
        String selectedFeature;
        do {
            selectedFeature = readFeature();
            performSelectedFeature(selectedFeature);
        } while (!selectedFeature.equals("Q"));
    }

    private void performSelectedFeature(String selectedFeature) {
        FeatureController featureController = new FeatureController();
        if(selectedFeature.equals("1")) {
            OutputView.printCourseMission();
            featureController.startPairMatch();
        }
        if(selectedFeature.equals("2")) {
            OutputView.printCourseMission();
            featureController.inquiryPairResult();
        }
        if(selectedFeature.equals("3")) {
            PairResult.resetPairMatchResult();
            OutputView.printResetMessage();
        }
    }

    private String readFeature() {
        String selectedFeature;
        while(true) {
            try {
                selectedFeature = InputView.readFeature();
                Validator.validateSelectedFeature(selectedFeature);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return selectedFeature;
    }
}

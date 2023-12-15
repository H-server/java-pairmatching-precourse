package pairmatching.controller;

import java.util.List;
import pairmatching.model.PairMatch;
import pairmatching.model.PairResult;
import pairmatching.util.Util;
import pairmatching.util.Validator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class FeatureController {
    private static final PairMatch pairMatch = new PairMatch();

    public void startPairMatch() {
        List<String> courseLevelMission = Util.splitByComma(InputView.getValidatedCourseLevelMission());
        boolean hasPairMatchResult = PairResult.checkPairMatchResult(courseLevelMission);
        if(!hasPairMatchResult) {
            pairMatch.setPair(courseLevelMission);
        }
        if(hasPairMatchResult) {
            retryPairMatch(courseLevelMission);
        }
    }



    private void retryPairMatch(List<String> courseLevelMission) {
        boolean retryMatching = hasExistingMatch();
        if(retryMatching) {
            pairMatch.setPair(courseLevelMission);
        }
        if(!retryMatching) {
            startPairMatch();
        }
    }

    public void inquiryPairResult() {
        List<String> courseLevelMission = Util.splitByComma(InputView.getValidatedCourseLevelMission());
        boolean hasResult = PairResult.checkPairMatchResult(courseLevelMission);
        if(!hasResult) {
            throw new IllegalStateException("[ERROR] 해당하는 페어 결과가 없습니다.");
        }
        if(hasResult) {
            OutputView.printPairMatchResult(courseLevelMission);
        }
    }

//    private String getValidatedCourseLevelMission() {
//        String courseLevelMission;
//        while(true) {
//            try {
//                courseLevelMission = InputView.readCourseLevelMission();
//                Validator.validateCourseLevelMission(courseLevelMission);
//                break;
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        return courseLevelMission;
//    }

    private boolean hasExistingMatch() {
        String yesOrNo = InputView.readReMatching();
        if(!(yesOrNo.equals("아니오") || yesOrNo.equals("네"))) {
            throw new IllegalArgumentException();
        }
        return yesOrNo.equals("네");
    }
}

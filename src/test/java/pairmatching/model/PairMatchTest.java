package pairmatching.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PairMatchTest {
    @Test
    void 같은_레벨_유일한_페어_체크() {
        List<String> courseLevelMission = Arrays.asList("백엔드", "레벨1", "자동차경주");
        PairResult.addPairMatchResult(Arrays.asList("백엔드", "레벨1", "로또"), Arrays.asList(Arrays.asList("Alice", "Bob"), Arrays.asList("Charlie", "David")));
        List<List<String>> pairResult = Arrays.asList(Arrays.asList("Eve", "Frank"), Arrays.asList("Grace", "Henry"));

        boolean result = PairResult.checkSameLevelUniquePair(courseLevelMission, pairResult);

        assertTrue(result);
    }

    @Test
    void 레벨_유일한_쌍_체크_거짓_테스트() {
        List<String> courseLevelMission = Arrays.asList("백엔드", "레벨1", "자동차경주");
        PairResult.addPairMatchResult(Arrays.asList("백엔드", "레벨1", "로또"), Arrays.asList(Arrays.asList("Alice", "Bob"), Arrays.asList("Charlie", "David")));
        List<List<String>> pairResult = Arrays.asList(Arrays.asList("Alice", "Bob"), Arrays.asList("Grace", "Henry"));

        boolean result = PairResult.checkSameLevelUniquePair(courseLevelMission, pairResult);

        assertFalse(result);
    }

}
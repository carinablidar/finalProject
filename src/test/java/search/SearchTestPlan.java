package search;

import base.TestCase;
import base.TestPlan;
import commons.LoggerUtility;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTestPlan implements TestPlan {

    List<TestCase> testCases = List.of(
            new SearchIphoneTestCase(),
            new SearchSamsungTestCase()
            );
    @Override
    @Test
    public void executePlan() {
        testCases.forEach(TestCase::runTest);
        LoggerUtility.infoTest("***");
        LoggerUtility.infoTest("Test Case 5. Search for Iphone is executed");
        LoggerUtility.infoTest("Test Case 6. Search for Samsung is executed");
        LoggerUtility.infoTest("***");
    }
}

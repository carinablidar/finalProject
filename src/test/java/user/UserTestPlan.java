package user;

import base.TestCase;
import base.TestPlan;
import commons.LoggerUtility;
import org.testng.annotations.Test;

import java.util.List;

public class UserTestPlan implements TestPlan {
    List<TestCase> testCases = List.of(
            new RegisterTestCase(),
            new LogInTestCase()
    );

    @Override
    @Test
    public void executePlan() {
        testCases.forEach(TestCase::runTest);
        LoggerUtility.infoTest("***");
        LoggerUtility.infoTest("Test Case 1. Register is executed");
        LoggerUtility.infoTest("Test Case 2. Log In is executed");
        LoggerUtility.infoTest("***");
    }
}

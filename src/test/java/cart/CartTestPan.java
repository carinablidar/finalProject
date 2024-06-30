package cart;

import base.TestCase;
import base.TestPlan;
import commons.LoggerUtility;
import org.testng.annotations.Test;
import user.LogInTestCase;
import user.RegisterTestCase;

import java.util.List;

public class CartTestPan implements TestPlan {
    List<TestCase> testCases = List.of(
            new AddToCartTestCase(),
            new DeleteFromCartTestCase()
    );


    @Override
    @Test
    public void executePlan() {
        testCases.forEach(TestCase::runTest);
        LoggerUtility.infoTest("***");
        LoggerUtility.infoTest("Test Case 3. Add to shopping cart is executed");
        LoggerUtility.infoTest("Test Case 4. Delete from shopping cart is executed");
        LoggerUtility.infoTest("***");
    }
}

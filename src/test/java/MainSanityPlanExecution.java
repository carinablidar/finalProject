import base.TestPlan;
import cart.CartTestPan;
import org.testng.annotations.Test;
import search.SearchTestPlan;
import user.UserTestPlan;

import java.util.List;

public class MainSanityPlanExecution {

    @Test
    public void runFullSanityPlan() {

        List<TestPlan> testPlans = List.of(
                new UserTestPlan(),
                new CartTestPan(),
                new SearchTestPlan()
        );
        testPlans.forEach(TestPlan::executePlan);
    }

}

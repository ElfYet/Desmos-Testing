import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This class contains the unit tests for trig functions in Desmos.com.
 */
public class TrigUnitTests extends DesmosTestBaseClass {
    /**
     * Performs the input and checks against the expected value.
     * @param input
     * @throws InterruptedException
     */
    public void UseTrig(String[] input) throws InterruptedException {
        int expectedOutput = Integer.parseInt(input[input.length - 1]);
        TestHelper.EmitKeys(driver, input[0]);
        Thread.sleep(200);
        System.out.println("Expected Output: " + expectedOutput + " | Actual Output: " + TestHelper.GetOutput(driver));
        Assert.assertEquals(TestHelper.GetOutput(driver), expectedOutput);
        TestHelper.ClearInputBox(driver, 20);
    }

    @Test
    public void TestTrig() throws InterruptedException {
        String[][] inputs = {
                {"sin(pi)", "0"},
                {"sin(pi/2)", "1"},
                {"cos(pi)", "-1"},
                {"cos(pi/2)", "0"},
                {"tan(pi)", "0"},
                {"tan(pi/4)", "1"}
        };

        for(String[] input : inputs) {
            UseTrig(input);
        }
    }
}
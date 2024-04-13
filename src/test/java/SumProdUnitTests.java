import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit tests for summation and product functionality of Desmos.
 */
public class SumProdUnitTests extends DesmosTestBaseClass {
    /**
     * Allows for testing the recursive functions in Desmos.
     * @param inputs {startNum, endNum, function, expectedValue}
     * @throws InterruptedException
     */
    public void UseRecursiveFunc(String[] inputs) throws InterruptedException {
        TestHelper.EmitKeys(driver, inputs[0]);
        TestHelper.NavUp(driver);
        TestHelper.EmitKeys(driver, inputs[1]);
        TestHelper.NavRight(driver);
        TestHelper.EmitKeys(driver, inputs[2]);
        Thread.sleep(200);
        System.out.println("Expected Output: " + inputs[inputs.length - 1] + " | Actual Output: " + TestHelper.GetOutput(driver));
        Assert.assertEquals(TestHelper.GetOutput(driver), Integer.parseInt(inputs[inputs.length - 1]));
        Thread.sleep(200);
        TestHelper.ClearInputBox(driver, 50);
    }

    @Test
    public void TestSummation() throws InterruptedException {
        String[][] inputs = {
                {"sum1", "10", "10", "100"},
                {"sum4", "8", "3", "15"}
        };

        for(String[] input : inputs) {
            UseRecursiveFunc(input);
        }
    }

    @Test
    public void TestSumProduct() throws InterruptedException {
        String[][] inputs = {
                {"prod2", "9", "3", "6561"},
                {"prod4", "8", "2", "32"}
        };

        for(String[] input : inputs) {
            UseRecursiveFunc(input);
        }
    }
}
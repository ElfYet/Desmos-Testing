import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests the normal operators in Desmos.
 */
public class OperatorUnitTests extends DesmosTestBaseClass {
    /**
     * Performs the operator and checks if it returns the expected output.
     * @param input
     * @param expectedOutput
     * @throws InterruptedException
     */
    public void PerformOperation(String input, int expectedOutput) throws InterruptedException {
        TestHelper.EmitKeys(driver, input);
        Thread.sleep(200);
        System.out.println("Expected Output: " + expectedOutput + " | Actual Output: " + TestHelper.GetOutput(driver));
        Assert.assertEquals(TestHelper.GetOutput(driver), expectedOutput);
        Thread.sleep(200);
        TestHelper.ClearInputBox(driver, 20);
    }

    /**
     * Tests the addition operator.
     */
    @Test
    public void TestAddition() throws InterruptedException {
        String[] inputs = {"2+2", "10+2+6"};
        int[] outputs = {4, 18};

        for (int i = 0; i < inputs.length; i++) {
            PerformOperation(inputs[i], outputs[i]);
            Thread.sleep(100);
        }
    }

    /**
     * Tests the multiplication operator.
     */
    @Test
    public void TestMultiplication() throws InterruptedException {
        String[] inputs = {"2*2", "10*2*6"};
        int[] outputs = {4, 120};

        for (int i = 0; i < inputs.length; i++) {
            PerformOperation(inputs[i], outputs[i]);
            Thread.sleep(100);
        }
    }

    /**
     * Tests the subtraction operator.
     */
    @Test
    public void TestSubtraction() throws InterruptedException {
        String[] inputs = {"2-2", "20-6"};
        int[] outputs = {0, 14};

        for (int i = 0; i < inputs.length; i++) {
            PerformOperation(inputs[i], outputs[i]);
            Thread.sleep(100);
        }
    }

    /**
     * Tests the exponent operator.
     */
    @Test
    public void TestExponent() throws InterruptedException {
        String[] inputs = {"2^2", "2^2^2"};
        int[] outputs = {4, 16};

        for (int i = 0; i < inputs.length; i++) {
            PerformOperation(inputs[i], outputs[i]);
            Thread.sleep(100);
        }
    }

    /**
     * Tests mixed operators.
     */
    @Test
    public void TestMixedOperators() throws InterruptedException {
        String[] inputs = {"(11-2^4+8*2-1)/2"};
        int[] outputs = {5};

        for (int i = 0; i < inputs.length; i++) {
            PerformOperation(inputs[i], outputs[i]);
            Thread.sleep(100);
        }
    }
}
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Contains the unit tests for graphing functionality.
 */
public class GraphUnitTests extends DesmosTestBaseClass {
    /**
     * Creates the provided graph and checks if the graph was generated.
     * @param input The function to graph.
     * @throws InterruptedException
     */
    public void Graph(String input) throws InterruptedException {
        TestHelper.EmitKeys(driver, input);
        Thread.sleep(200);
        if (HasGraph()) {
            System.out.println("The graph '" + input + "' displayed correctly.");
        }
        else {
            System.out.println("The graph '" + input + "' displayed incorrectly.");
        }
        Assert.assertTrue(HasGraph());
        Thread.sleep(200);
        TestHelper.ClearInputBox(driver, 20);
    }

    /**
     * Checks if a graph was created.
     * @return
     */
    public boolean HasGraph() {
        String audioKey = "Press ALT+T for audio trace";
        var graph = driver.findElement(By.cssSelector("#graph-container > div > div > div > div.dcg-grapher.dcg-grapher-2d > div.dcg-graph-outer"));
        String ariaLabel = graph.getAttribute("aria-label");
        return ariaLabel.contains(audioKey);
    }

    /**
     * Graphs several lines and makes sure those graphs appear.
     * @throws InterruptedException
     */
    @Test
    public void GraphLine() throws InterruptedException {
        String[] inputs = {"y=2x", "y=6", "x=y"};
        for (String input : inputs) {
            Graph(input);
        }
    }

    /**
     * Graphs several parabolas and makes sure those graphs appear.
     * @throws InterruptedException
     */
    @Test
    public void GraphParabola() throws InterruptedException {
        String[] inputs = {"y=x^2-2x+2", "y=2^x+2", "x=y^2"};
        for (String input : inputs) {
            Graph(input);
        }
    }
}

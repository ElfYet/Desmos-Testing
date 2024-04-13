import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Make sure to set DRIVER_TYPE and DRIVER_LOCATION prior to running tests.
 */
public class TestHelper {
    /**
     * Change 'chrome' to the driver you are using.
     */
    static final String DRIVER_TYPE = "webdriver.chrome.driver";

    /**
     * Change the driver location to your driver location.
     */
    static final String DRIVER_LOCATION = "C:\\Users\\19415\\WebDrivers\\chromedriver.exe";

    /**
     * Gets a new web driver. Make sure to set DRIVER_TYPE and DRIVER_LOCATION in the class first.
     * @return A new WebDriver.
     */
    public static WebDriver GetWebDriver() {
        System.setProperty(DRIVER_TYPE, DRIVER_LOCATION);
        WebDriver driver = switch (DRIVER_TYPE) {
            case "webdriver.chrome.driver" -> new ChromeDriver();
            case "webdriver.edge.driver" -> new EdgeDriver();
            case "webdriver.gecko.driver" -> new FirefoxDriver();
            case "webdriver.safari.driver" -> new SafariDriver();
            default ->
                    throw new UnsupportedClassVersionError("Driver type is not supported: " + DRIVER_TYPE
                            + "\nSupported drivers are: Chrome, Edge, Firefox, and Safari.");
        };
        return driver;
    }

    /**
     * Gets the integer output from the first line in Desmos.
     * @param driver The web driver to use.
     * @return An integer.
     */
    public static int GetOutput(WebDriver driver) {
        var values = driver.findElement(By.cssSelector("#graph-container > div > div > div > div:nth-child(1) > div.dcg-exppanel-outer > div.dcg-exppanel-container.dcg-add-shadow.dcg-global-mute-on > div.dcg-exppanel.dcg-disable-horizontal-scroll-to-cursor > div > span.dcg-template-expressioneach > div > div.dcg-fade-container > div.dcg-expression-bottom.dcg-indent-in-folder.dcg-fadein-bottom > div.dcg-evaluation-container > div.dcg-evaluation.dcg-do-blur > div > div.dcg-typeset-math > span > div > span.dcg-mq-mathspeak"));
        String output = values.getAttribute("innerHTML");
        if (output.contains("negative")) {
            output = output.replace("negative", "-");
        }
        output = output.replace(" ", "");
        return Integer.parseInt(output);
    }

    /**
     * Sends the key inputs to Desmos. This allows you to type in the active entry box.
     * @param driver
     * @param keys Input to send to the active entry box.
     */
    public static void EmitKeys(WebDriver driver, String keys) {
        Actions actions = new Actions(driver);
        actions.sendKeys(keys);
        actions.build().perform();
    }

    /**
     * Sends the arrow up event to Desmos.
     * @param driver
     */
    public static void NavUp(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP);
        actions.build().perform();
    }

    /**
     * Sends the arrow right event to Desmos.
     * @param driver
     */
    public static void NavRight(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_RIGHT);
        actions.build().perform();
    }

    /**
     * Sends the arrow down event to Desmos.
     * @param driver
     */
    public static void NavDown(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.build().perform();
    }

    /**
     * Deletes the number of characters provided.
     * @param charsToDelete
     */
    public static void ClearInputBox(WebDriver driver, int charsToDelete) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Actions actions = new Actions(driver);
        for (int i = 0; i < charsToDelete; i++) {
            actions.sendKeys(Keys.BACK_SPACE);
        }
        actions.build().perform();
    }
}
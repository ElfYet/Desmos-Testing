import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class DesmosTestBaseClass {
    protected WebDriver driver;

    @BeforeClass
    public void BeforeClassTest() throws InterruptedException {
        driver = TestHelper.GetWebDriver();
        driver.get("https://www.desmos.com/calculator");
        Thread.sleep(3000);
    }

    @AfterClass
    public void AfterClassTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @AfterMethod
    public void Cleanup() {
        TestHelper.ClearInputBox(driver, 30);
    }
}
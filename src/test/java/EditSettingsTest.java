import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class EditSettingsTest {

    @Test
    void settings_options() throws InterruptedException {

        // Start up driver and go to webpage (maximize + 2sec sleep)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\19415\\WebDrivers\\chromedriver.exe"); // Path to WebDriver
        WebDriver driver = new ChromeDriver(); //Initialize a driver
        driver.get("https://www.desmos.com/calculator"); //paste Desmos URL here
        driver.manage().window().maximize(); // Command to maximize URL
        Thread.sleep(2000); // Delay Thread by 2sec, sleep throws error (add exception)

        // Get the title
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        // Get the current URL of the selected webpage
        String url = driver.getCurrentUrl();
        System.out.println(url);

        // Find container with text box
        WebElement calcBox = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[1]/div[1]/div[2]/div[4]/div/span[1]/div[1]/div[1]/div[1]"));
        calcBox.click(); // Click container
        Thread.sleep(1000);

        // Find graphing text box
        WebElement calcInput = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[1]/div[1]/div[2]/div[4]/div/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div/div[2]/span[2]/textarea"));
        calcInput.sendKeys("2x+5"); // input line graph
        Thread.sleep(2000);

        // Find graph settings button
        WebElement graphSettings = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[4]/div[2]/div/div[2]/div[2]/div[1]/div"));
        graphSettings.click(); // Click container
        Thread.sleep(1000);

        // Find large font size setting
        WebElement fontSizeLarge = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[4]/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/div[2]"));
        fontSizeLarge.click();
        Thread.sleep(1000);

        // Find small font size setting
        WebElement fontSizeSmall = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[4]/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/div[1]"));
        fontSizeSmall.click();
        Thread.sleep(1000);

        // Find reverse contrast setting
        WebElement reverseContrast = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[4]/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[2]/span[1]"));
        reverseContrast.click(); // check reverse contrast
        Thread.sleep(1500);
        reverseContrast.click(); // uncheck reverse contrast
        Thread.sleep(1000);

        // Find grid setting
        WebElement grid = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[4]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[1]/span[1]"));
        grid.click(); // uncheck grid
        Thread.sleep(1000);

        // Find axis numbers setting
        WebElement axisNumbers = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[4]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[1]/span[1]"));
        axisNumbers.click();
        Thread.sleep(1000);

        // Find X-axis setting
        WebElement xAxis = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[4]/div[2]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div[1]/span[1]"));
        xAxis.click();
        Thread.sleep(1000);

        // Find Y-axis setting
        WebElement yAxis = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[4]/div[2]/div/div[2]/div[2]/div[2]/div/div[3]/div[3]/div[1]/span[1]"));
        yAxis.click();
        Thread.sleep(1000);

        driver.close(); // Close the window
        driver.quit(); // Exit out of driver executables

    }
}

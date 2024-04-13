import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class KeyboardTest {

    @Test(priority = 2)
    void use_keyboard() throws InterruptedException {

        // Start up driver and go to webpage (maximize + 2sec sleep)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\19415\\WebDrivers\\chromedriver.exe"); // Path to WebDriver
        WebDriver driver = new ChromeDriver(); //Initialize a driver
        driver.get("https://www.desmos.com/calculator"); //paste Desmos URL here
        driver.manage().window().maximize(); // Command to maximize URL
        Thread.sleep(2000); // Delay Thread by 2sec, sleep throws error (add exception)

        // Find keyboard
        WebElement keyboard = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[11]/div[2]/div/div"));
        keyboard.click(); // Click keyboard icon
        Thread.sleep(2000);

        // Find num 2
        WebElement click5 = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[11]/div[1]/div/div[1]/div[1]/div[2]/div[7]/span"));
        click5.click(); // Click num 5 button
        Thread.sleep(1000);

        // Find x button
        WebElement clickX = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[11]/div[1]/div/div[1]/div[1]/div[1]/div[1]/span"));
        clickX.click(); // Click x button
        Thread.sleep(1000);

        // Find squared button
        WebElement clickSquared = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[11]/div[1]/div/div[1]/div[1]/div[1]/div[3]/span"));
        clickSquared.click(); // Click squared button
        Thread.sleep(1000);

        // Find plus button
        WebElement clickPlus = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[11]/div[1]/div/div[1]/div[1]/div[4]/div[8]/span"));
        clickPlus.click(); // Click plus button
        Thread.sleep(1000);

        WebElement click3 = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[11]/div[1]/div/div[1]/div[1]/div[3]/div[8]/span"));
        click3.click(); // Click num 3 button
        Thread.sleep(1000);

        WebElement clickEnter = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[11]/div[1]/div/div[1]/div[1]/div[4]/div[10]/span"));
        clickEnter.click(); // Click enter button
        Thread.sleep(1000);

        driver.close(); // Close the window
        driver.quit(); // Exit out of driver executables

    }
}
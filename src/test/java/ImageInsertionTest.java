import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ImageInsertionTest {

    @Test
    void upload_image() throws InterruptedException, AWTException {

        // Start up driver and go to webpage (maximize + 2sec sleep)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\19415\\WebDrivers\\chromedriver.exe"); // Path to WebDriver
        WebDriver driver = new ChromeDriver(); //Initialize a driver
        driver.get("https://www.desmos.com/calculator"); //paste Desmos URL here
        driver.manage().window().maximize(); // Command to maximize URL
        Thread.sleep(2000); // Delay Thread by 2sec, sleep throws error (add exception)

        // Find the Add button menu
        WebElement clickAddMenu = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button")); // Initialize dropDown element
        clickAddMenu.click(); // Click the Add menu
        Thread.sleep(1000);

        // Locate image button
        WebElement imageButton = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div/div[5]/div"));
        imageButton.click(); // Click image button
        Thread.sleep(1000);

        // Upload image
        WebElement fileInput = driver.findElement(By.cssSelector("#graph-container > div > div > div > div:nth-child(1) > div.dcg-exppanel-outer > div.dcg-exppanel-container.dcg-add-shadow.dcg-global-mute-on > div.dcg-expression-top-bar > div.dcg-add-expression-container > div.dcg-add-expression-dropdown.dcg-popover.dcg-bottom > div > div:nth-child(5) > input[type=file]"));
        fileInput.sendKeys("C:/Users/19415/IdeaProjects/Software_Testing_Final/Apple Background.jpg"); // Select apple background image from files

        // 1st attempt at closing file explorer window (Didn't work)
        /*
        // Close the file explorer window using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.onbeforeunload = function(e){};");
        */

        // Close the file explorer window using Robot class, Simulate pressing Alt-f4
        // Source: Java SE documentation provided by Oracle, Robot Class
        Robot robot = new Robot();
        robot.delay(1000); // Delay to allow the file explorer window to focus
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_F4);

        Thread.sleep(2000);

        driver.close(); // Close the window
        driver.quit(); // Exit out of driver executables

    }
}
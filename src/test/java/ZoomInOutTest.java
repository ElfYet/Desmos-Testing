import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ZoomInOutTest {

    @Test
    void zoom_in_and_out() throws InterruptedException {

        // Start up driver and go to webpage (maximize + 2sec sleep)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\19415\\WebDrivers\\chromedriver.exe"); // Path to WebDriver
        WebDriver driver = new ChromeDriver(); //Initialize a driver
        driver.get("https://www.desmos.com/calculator"); //paste Desmos URL here
        driver.manage().window().maximize(); // Command to maximize URL
        Thread.sleep(2000); // Delay Thread by 2sec, sleep throws error (add exception)

        // Find container with text box
        WebElement calcBox01 = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[1]/div[1]/div[2]/div[4]/div/span[1]/div[1]/div[1]/div[1]"));
        calcBox01.click(); // Click container
        Thread.sleep(500);

        // Find graphing text box
        WebElement calcInput01 = driver.findElement(By.xpath("//*[@id=\"graph-container\"]/div/div/div/div[1]/div[1]/div[2]/div[4]/div/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div/div[2]/span[2]/textarea"));
        calcInput01.sendKeys("(x)^2+(y)^2=3.5"); // input line graph
        Thread.sleep(500);

        // Demonstrate zooming in and out using provided buttons
        WebElement zoomIn = driver.findElement(By.className("dcg-action-zoomin"));
        zoomIn.click();
        zoomIn.click();
        zoomIn.click();
        Thread.sleep(500);
        WebElement zoomOut = driver.findElement(By.className("dcg-action-zoomout"));
        zoomOut.click();
        zoomOut.click();
        zoomOut.click();

        Thread.sleep(1000);

        driver.close(); // Close the window
        driver.quit(); // Exit out of driver executables

    }
}
package puzzle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase {
    @Test
    public void click() {
        WebDriver driver =  WebDriverManager.chromedriver().create();
        driver.get("https://zzzscore.com/1to50/en/");
        // Solve the puzzle
        try {
            for (int i = 1; i <= 50; i++) {
                // Find and click the element with the current number
                WebElement numberElement = driver.findElement(By.xpath("//div[text()='" + i + "']"));
                numberElement.click();
                Thread.sleep(100); // Add a small delay between clicks for stability
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

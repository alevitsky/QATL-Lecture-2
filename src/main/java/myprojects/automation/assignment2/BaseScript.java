package myprojects.automation.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     *
     * @return New instance of {@link WebDriver} object.
     */
    public static WebDriver getDriver() {
        String driverPath = System.getProperty("webdriver.chrome.driver");
        if (driverPath == null) {
            // Linux
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            // Windows
            // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        }
        return new ChromeDriver();
    }

    protected static void waitFor(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    protected static void shopAdminAuthentication(WebDriver driver) {
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys("webinar.test@gmail.com");
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement submitLogin = driver.findElement(By.name("submitLogin"));
        submitLogin.submit();
    }
}

package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseScript {

    public static void main(String[] args) {
        WebDriver driver = getDriver();

        try {
            testLoginAndLogout(driver);
        } finally {
            driver.quit();
        }

    }

    private static void testLoginAndLogout(WebDriver driver) {
        driver.get(Properties.getBaseAdminUrl());
        waitFor(2500);
        shopAdminAuthentication(driver);
        waitFor(1000);
        WebElement profile = driver.findElement(By.id("employee_infos"));
        profile.click();
        waitFor(1000);
        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();
    }
}

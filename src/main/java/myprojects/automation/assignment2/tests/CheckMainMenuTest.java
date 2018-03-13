package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CheckMainMenuTest extends BaseScript {

    public static void main(String[] args) {
        WebDriver driver = getDriver();

        try {
            testAdminPanelMainMenu(driver);
        } finally {
            driver.quit();
        }

    }

    private static void testAdminPanelMainMenu(WebDriver driver) {
        driver.get(Properties.getBaseAdminUrl());
        waitFor(2500);
        shopAdminAuthentication(driver);
        waitFor(1000);
        final List<String> values = Collections.unmodifiableList(Arrays.asList(
                "1", "3", "9", "23", "27", "31", "42", "46", "52", "55", "58", "73", "95"
        ));
        values.forEach(value -> testMenuItem(driver, value));
    }

    private static void testMenuItem(WebDriver driver, String value) {
        String expr = String.format("//li[@data-submenu=\"%s\"]", value);
        waitFor(1000);
        WebElement menuItem = driver.findElement(By.xpath(expr));
        menuItem.click();
        waitFor(1000);
        String expectedTitle = driver.findElement(By.tagName("h2")).getText();
        System.out.println(expectedTitle);
        driver.navigate().refresh();
        String actualTitle = driver.findElement(By.tagName("h2")).getText();
        if (!Objects.equals(expectedTitle, actualTitle)) {
            String formattedMessage =
                    String.format("Actual title %s doesn't match with the expected %s", actualTitle, expectedTitle);
            throw new AssertionError(formattedMessage);
        }
    }
}


package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloSadhanaTest {

    @Test
    public void testMessage() throws Exception {

        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new RemoteWebDriver(
            new URL("http://localhost:4444/wd/hub"),
            options
        );

        try {
            driver.get("data:text/html,"
                + "<html><body><h1 id='message'>"
                + "Hello Sadhana Gowda, this is devops lab !!!"
                + "</h1></body></html>");

            String actualMessage = driver.findElement(
                By.id("message")).getText();

            String expectedMessage =
                "Hello Sadhana Gowda, this is devops lab !!!";

            assertEquals(expectedMessage, actualMessage);

            System.out.println(actualMessage);

        } finally {
            driver.quit();
        }
    }
}

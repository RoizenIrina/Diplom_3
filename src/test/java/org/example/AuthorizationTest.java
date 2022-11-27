package org.example;

import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class AuthorizationTest {
    WebDriver driver = new ChromeDriver();

    final String email;
    final String password;

    public AuthorizationTest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {}, // подумать как написать
                {},
        };
    }

    @After
    public void teardown() {
        driver.quit();
    }

}

package org.example;

import objpages.AuthorizationPage;
import objpages.MainPageBurger;
import objpages.RegistrationPage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegistrationTest {
    WebDriver driver = new ChromeDriver();

    final String login;
    final String email;
    final String password;

    public RegistrationTest(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"ivanov", "ivanov@ya.ru", "123456"},
                {"Петров", "petrov@ya.ru", "Петров"},
        };
    }

    @Test
    public void checkRegistrationTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.open();
        objAuthorizationPage.clickRegistrationLink();
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.userNameRegistration(login);
        objRegistrationPage.userEmailRegistration(email);
        objRegistrationPage.userPasswordRegistration(password);
        objRegistrationPage.clickRegistrationButton();
        objAuthorizationPage.userEmail(email);
        objAuthorizationPage.userPassword(password);
        objAuthorizationPage.clickLoginButton();
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.findOrderButton();
        assertEquals("RegistrationFaild", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @After
    public void teardown() {
        driver.quit();
    }

}

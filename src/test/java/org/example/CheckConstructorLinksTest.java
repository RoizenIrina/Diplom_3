package org.example;

import io.qameta.allure.junit4.DisplayName;
import objpages.MainPageBurger;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class CheckConstructorLinksTest {


WebDriver driver = new ChromeDriver();
//    @Test
//    @DisplayName("check Constructor Sauce Link at MainPage")
//    public void Test() {
//        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/yadriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C:/Users/Asus Zenbook/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
//        objMainPageBurger.open();
//        assertTrue("Error in section Links-Sauce",  objMainPageBurger.checkSauceLinkDisplayed());
//    }


    @Test
    @DisplayName("check Constructor Sauce Link at MainPage")
    public void checkSauceLink() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        assertTrue("Error in section Links-Sauce",  objMainPageBurger.checkSauceLinkDisplayed());
    }

    @Test
    @DisplayName("check Constructor Buns Link at MainPage")
    public void checkBunsLink() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        assertTrue("Error in section Links-Buns",  objMainPageBurger.checkBunsLinkDisplayed());
    }

    @Test
    @DisplayName("check Constructor Stuffing Link at MainPage")
    public void checkStuffingLink() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        assertTrue("Error in section Links-Stuffing",  objMainPageBurger.checkStuffingLinkDisplayed());
    }


  @After       // Закрыть браузер
 public void teardown() {
   driver.quit();
    }

}
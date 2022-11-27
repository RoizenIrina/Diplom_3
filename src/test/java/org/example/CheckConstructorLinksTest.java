package org.example;

import objpages.MainPageBurger;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class CheckConstructorLinksTest {

//    public void setDriver() {
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C:/Users/Asus Zenbook/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
//        WebDriver driver = new ChromeDriver(options);
//    }
WebDriver driver = new ChromeDriver();

    @Test
    public void checkSauceLink() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        assertTrue("Error in section Links-Sauce",  objMainPageBurger.checkSauceLinkDisplayed());
    }

    @Test
    public void checkBunsLink() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        assertTrue("Error in section Links-Buns",  objMainPageBurger.checkBunsLinkDisplayed());
    }

    @Test
    public void checkStuffingLink() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        assertTrue("Error in section Links-Stuffing",  objMainPageBurger.checkStuffingLinkDisplayed());
    }


  @After       // Закрой браузер
 public void teardown() {
   driver.quit();
    }

}
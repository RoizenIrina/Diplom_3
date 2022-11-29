package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YandexOptions {

    public YandexOptions (){
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/yadriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Users/Asus Zenbook/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
        WebDriver driver = new ChromeDriver(options);
    }
}

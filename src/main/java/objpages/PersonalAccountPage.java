package objpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {

    private final WebDriver driver;
    private final static String personalAccountPage = "https://stellarburgers.nomoreparties.site/";
    private final By
            exitButton = By.xpath("/html/body/div[1]/div/main/div/nav/ul/li[3]/button"),
            logoButton = By.xpath("/html/body/div[1]/div/header/nav/div/a/svg"),
            constructorButton = By.xpath("/html/body/div[1]/div/header/nav/ul/li[1]/a/p");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    //	выход из аккаунта через кнопку 'выход' в личном кабинете
    public void clickExitButton(By exitButton) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();
    }

    //	переход на главную страницу через символ логотипа в личном кабинете
    public void clickLogoButton(By logoButton) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(logoButton));
        driver.findElement(logoButton).click();
    }

    //	переход в раздел конструктор на главной странице через ссылку в личном кабинете
    public void clickConstructorButton(By constructorButton) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(constructorButton));
        driver.findElement(constructorButton).click();
    }

}
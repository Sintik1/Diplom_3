package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By fieldEmail = By.xpath(".//input[@type='text']");//локатор поля емайл
    private By fieldPassword = By.xpath(".//input[@type='password']");//локатор поля пароль
    private By buttonLogIn = By.xpath(".//button[contains(text(),'Войти')]");//локатор кнопки Войти
    private By buttonRegister = By.xpath(".//a[contains(text(),'Зарегистрироваться')]");//локатор кнопки Зарегистрироваться
    private By buttonForgotPassword = By.xpath(".//a[@href='/forgot-password']");//локатор кнопки Восстановление пароля
    private By headPage = By.xpath(".//main[@class='App_componentContainer__2JC2W']");//Локатор главной страницы

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке регистрация")
    public void clickButtonRegister() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonRegister));
        driver.findElement(buttonRegister).click();
    }

    @Step("Заполнение поля email")
    public void sendFieldEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldEmail));
        driver.findElement(fieldEmail).click();
        driver.findElement(fieldEmail).sendKeys(email);
    }

    @Step("Заполнение поля пароль")
    public void sendFieldPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldPassword));
        driver.findElement(fieldPassword).click();
        driver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("Клик по кнопке Войти")
    public void clickButtonLogin() {
        driver.findElement(buttonLogIn).click();
    }
     @Step("Отображения главной страницы после авторизации")
    public boolean headPageIsDisplayed(){
       return driver.findElement(headPage).isDisplayed();
    }
    @Step("Клик по кнопке восстановить пароль")
    public void clickButtonForgotPassword(){
        driver.findElement(buttonForgotPassword).click();
    }
    @Step("Отображения кнопки Войти на странице логина")
    public boolean isDisplayedButtonLogin(){
        new WebDriverWait(driver,Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLogIn));
       return driver.findElement(buttonLogIn).isDisplayed();
    }
}

package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HeadPage {
    private WebDriver driver;
    private By buttonPersonalArea = By.xpath(".//p[contains(text(),'Личный Кабинет')]");//Локатор кнопки Личный кабинет в хедере
    private By buttonSingIn = By.xpath(".//button[contains(text(),'Войти в аккаунт')]");//Локатор кнопки Войти в аккаунт
    private By buttonBun = By.xpath(".//span[contains(text(),'Булки')]");//Локатор кнопки Булки в конструкторе
    private By getNameSectionBunInConsctructor=By.xpath(".//h2[contains(text(),'Булки')]");//Локатор названия секции Булки
    private By buttonFillings = By.xpath(".//span[contains(text(),'Начинки')]");//Локатор кнопки Начинки в конструкторе
    private By nameSectionFillingsInConsctructor= By.xpath(".//h2[contains(text(),'Начинки')]");//Локатор названия секции Начинки
    private By buttonSause = By.xpath(".//span[contains(text(),'Соусы')]");//Локатор кнопки Соусы в конструкторе
    private By nameSectionSauseInConstructor=By.xpath(".//h2[contains(text(),'Соусы')]");//Локатор названия секции Соусы
    private By listConstructor = By.className("BurgerIngredients_ingredients__menuContainer__Xu3Mo");
    private By headPage = By.xpath(".//main[@class='App_componentContainer__2JC2W']");//Локатор главной страницы


    public HeadPage(WebDriver driver) {
        this.driver = driver;
    }


  @Step("Клик по кнопке Личный кабинет")
    public void clickButtonPersonalArea() {
        driver.findElement(buttonPersonalArea).click();
    }

    @Step("Клик по кнопке Войти в середине сайта")
    public void clickButtonSingIn() {
        driver.findElement(buttonSingIn).click();
    }

    @Step("Метод отображения списка ингредиентов конструктора")
    public boolean isDisplayedConstructor() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(listConstructor));
        return driver.findElement(listConstructor).isDisplayed();
    }

    @Step("Метод отображения главной страницы")
    public boolean isDisplayedHeadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(headPage));
        return driver.findElement(headPage).isDisplayed();
    }

    @Step("Получение названия секции Булки")
    public String getNameSectionBunConstructor() {
        return driver.findElement(getNameSectionBunInConsctructor).getText();
    }

    @Step("Получение названия секции Начинки")
    public String getNameSectionFillingsConstructor() {
        return driver.findElement(nameSectionFillingsInConsctructor).getText();
    }

    @Step("Получение названия секции Соусы")
    public String getNameSectionSauseConstructor() {
        return driver.findElement(nameSectionSauseInConstructor).getText();
    }

    @Step("Клик по кнопке Булки")
    public void clickButtonBun() {
        driver.findElement(buttonBun).click();
    }

    @Step("Клик по кнопке Начинки")
    public void clickButtonFillings() {
        driver.findElement(buttonFillings).click();
    }

    @Step("Клик по кнопке Соусы")
    public void clickButtonSause() {
        driver.findElement(buttonSause).click();
    }
}
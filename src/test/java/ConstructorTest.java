import POM.HeadPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConstructorTest {
    WebDriver driver;
    private static final String URI = "https://stellarburgers.nomoreparties.site/";
@Before
public void setUp(){
    //для тестов через Хром
    driver = new ChromeDriver();

    //Для тестов через Яндекс Браузер
    //System.setProperty("webdriver.chrome.driver", "/Users/vlad/Downloads/chromedriver_mac_arm64 (3) 2/chromedriver");
    //ChromeOptions chromeOptions =new ChromeOptions();
   // chromeOptions.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
   // driver=new ChromeDriver(chromeOptions);

}
    @Test
    @DisplayName("Кейс проверки корректного перехода на вкладку Начинки")
    @Description("Текст внутри конструктора должен соответствовать названию секции")
    public void goToSectionFillingsInConstructor() {
        driver.get(URI);
        HeadPage objHeadPage = new HeadPage(driver);
        objHeadPage.clickButtonFillings();
        Assert.assertEquals("Начинки",objHeadPage.getNameSectionFillingsConstructor());
    }
    @Test
    @DisplayName("Кейс проверки корректного перехода на вкладку Соусы")
    @Description("Текст внутри конструктора должен соответствовать названию секции")
    public void goToSectionSauseInConstructor() {
        driver.get(URI);
        HeadPage objHeadPage = new HeadPage(driver);
        objHeadPage.clickButtonSause();
        Assert.assertEquals("Соусы",objHeadPage.getNameSectionSauseConstructor());
    }
    @Test
    @DisplayName("Кейс проверки корректного перехода на вкладку Булки")
    @Description("Текст внутри конструктора должен соответствовать названию секции")
    public void goToSectionBunInConstructor() {
        driver.get(URI);
        HeadPage objHeadPage = new HeadPage(driver);
        objHeadPage.clickButtonFillings();
        objHeadPage.clickButtonBun();
        Assert.assertEquals("Булки",objHeadPage.getNameSectionBunConstructor());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}



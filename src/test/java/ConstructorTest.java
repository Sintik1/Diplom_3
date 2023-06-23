import POM.HeadPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.core.StringContains.containsString;

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
    @Description("Кнопка перехода в секцию должна быть активной")
    public void goToSectionFillingsInConstructor() {
        driver.get(URI);
        HeadPage objHeadPage = new HeadPage(driver);
        objHeadPage.clickButtonFillings();
        String actualResult=objHeadPage.getAtributFillings();
        MatcherAssert.assertThat(actualResult,containsString("current"));
    }
    @Test
    @DisplayName("Кейс проверки корректного перехода на вкладку Соусы")
    @Description("Кнопка перехода в секцию должна быть активной")
    public void goToSectionSauseInConstructor() {
        driver.get(URI);
        HeadPage objHeadPage = new HeadPage(driver);
        objHeadPage.clickButtonSause();
        String actualResult=objHeadPage.getAtributSause();
       MatcherAssert.assertThat(actualResult,containsString("current"));
    }
   @Test
    @DisplayName("Кейс проверки корректного перехода на вкладку Булки")
    @Description("Кнопка перехода в секцию должна быть активной")
    public void goToSectionBunInConstructor() {
        driver.get(URI);
        HeadPage objHeadPage = new HeadPage(driver);
        objHeadPage.clickButtonFillings();
        objHeadPage.clickButtonBun();
        String actualResult=objHeadPage.getAtributBuns();
        MatcherAssert.assertThat(actualResult,containsString("current"));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}



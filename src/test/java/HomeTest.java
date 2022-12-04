import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.HomePage;

import java.time.Duration;

import static constants.ConstantsHome.FIRST_ANSWER;
import static constants.ConstantsHome.SECOND_ANSWER;
import static org.junit.Assert.assertEquals;


public class HomeTest {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void FAQTest(){
        HomePage objHomePage = new HomePage(driver);
        String expectedFirst = objHomePage.getTextAnswerFirstFAQ();
        String expectedSecond = objHomePage.getTextAnswerSecondFAQ();
        objHomePage.clickCloseCookie();
        assertEquals("Текст первого ответа не соответствует ожидаемому", FIRST_ANSWER, expectedFirst);
        assertEquals("Текст второго ответа не соответствует ожидаемому", SECOND_ANSWER, expectedSecond);

    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }


}

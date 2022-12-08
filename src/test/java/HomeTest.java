import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.HomePage;

import java.util.concurrent.TimeUnit;

import static constants.ConstantsHome.*;


@RunWith(Parameterized.class)
public class HomeTest {

    private final int question;
    private final String answer;

    WebDriver driver;

    public HomeTest(int question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {1, FIRST_ANSWER}, {2, SECOND_ANSWER}, {3, THIRD_ANSWER}, {4, FOURTH_ANSWER},
                {5, FIFTH_ANSWER}, {6, SIXTH_ANSWER}, {7, SEVENTH_ANSWER}, {8, EIGHTH_ANSWER}
        };
        }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void FAQTest(){
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickCloseCookie();
        String actualAnswer = objHomePage.getTextAnswer(question);
        System.out.println(actualAnswer);
        Assert.assertEquals("Текст ответа не соответствует ожидаемому", answer, actualAnswer);

    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }


}

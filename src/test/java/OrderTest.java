import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.OrderPage;

import java.time.Duration;

import static constants.ConstantsOrder.COLOR;
import static constants.ConstantsOrder.ORDER_SUCCESSFUL;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String deliveryDate;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    WebDriver driver;

    public OrderTest(String name, String surname, String address, String metro, String phone, String date, String period, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.deliveryDate = date;
        this.rentalPeriod = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                { "Анастасия", "Граф", "Калининград Театральная 8", "Коньк", "89529999999", "12.15.2022", "сутки", COLOR, "Тест тест тест111!"},
                { "Вася", "Пупкин", "Москва Театральная 8", "Зяблик", "89529999901", "01.01.2023", "пятеро суток", "", ""},
        };
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void OrderTest() {
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.clickCloseCookie();
        objOrderPage.clickHeaderOrderButton();
        objOrderPage.setName(name);
        objOrderPage.setSurname(surname);
        objOrderPage.setDeliveryAddress(address);
        objOrderPage.setMetroStation(metro);
        objOrderPage.setPhone(phone);
        objOrderPage.clickButtonOnwards();
        objOrderPage.setDeliveryDate(deliveryDate);
        objOrderPage.setRentalPeriod(rentalPeriod);
        objOrderPage.setColor(color);
        objOrderPage.setComment(comment);
        objOrderPage.doOrder();
        objOrderPage.clickOrderConfirm();
        String expected = objOrderPage.orderSuccessful();
        assertEquals("Ошибка, заказ не оформлен", ORDER_SUCCESSFUL, expected);

    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}

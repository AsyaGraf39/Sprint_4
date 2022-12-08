package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static constants.ConstantsOrder.COLOR;

public class OrderPage {

    public WebDriver driver;

    //Локатор кнопки закрытия плашки про куки
    private By closeCookie = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    //Локатор кнопки "Заказать" в шапке
    private By headerOrder = By.xpath(".//button[@class='Button_Button__ra12g']");

    //Локатор кнопки "Заказать" на главной странице
    private By roadMapOrder = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM')]");

    //Локатор поля имени
    private By name = By.xpath(".//input[@placeholder='* Имя']");

    //Локатор поля фамилии
    private By surname = By.xpath(".//input[@placeholder='* Фамилия']");

    //Локатор поля Адреса доставки
    private By deliveryAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Локатор поля станции метро
    private By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");

    //Локатор выпадающего списка со станциями метро
    private By selectMetroStation = By.xpath(".//*[@class='select-search__select']");

    //Локатор поля телефона клиента
    private By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Локатор кнопки Далее
    private By onwards = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM')]");

    //Локатор даты доставки
    private By deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Локатор для выбранной даты в календаре
    private By selectDate = By.xpath(".//div[contains(@class, 'react-datepicker__day--selected')]");

    //Локатор поля срока аренды
    private By rentalPeriod = By.xpath(".//div[text()='* Срок аренды']");

    //Локатор список элементов срока аренды
    private By listRentalPeriod = By.xpath(".//div[@class='Dropdown-option']");

    //Локатор черного цвета самоката
    private By blackColor = By.xpath(".//label[@for='black']");

    //Локатор серого цвета самоката
    private By greyColor = By.xpath(".//label[@for='grey']");

    //Локатор комментария для курьера
    private By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Локатор кнопки создания заказа
    private By buttonOrder = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']");

    //Локатор подтверждения заказа
    private By btnOrderConfirm = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text()='Да']");

    //Локатор заголовка в попапе об успешном заказе
    private By orderSuccessful = By.xpath(".//did[@class = 'Order_ModalHeader__3FDaJ']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCloseCookie() {
        driver.findElement(closeCookie).click();
    }

    public void clickOrderButton(boolean isBtnOrderHeader) {
        if (isBtnOrderHeader) {
            driver.findElement(headerOrder).click();
        } else {
            WebElement elRoadMapBtnOrder = driver.findElement(roadMapOrder);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elRoadMapBtnOrder);
            elRoadMapBtnOrder.click();
        }
    }

    public void setName(String userName) {
        driver.findElement(name).sendKeys(userName);
    }
    public void setSurname(String userSurname) {
        driver.findElement(surname).sendKeys(userSurname);
    }
    public void setDeliveryAddress(String address) {
        driver.findElement(deliveryAddress).sendKeys(address);
    }
    public void setMetroStation(String selectMetro) {
        driver.findElement(metroStation).click();
        driver.findElement(metroStation).sendKeys(selectMetro);
        driver.findElement(selectMetroStation).click();
    }
    public void setPhone(String userPhone) {
        driver.findElement(phone).sendKeys(userPhone);
    }
    public void clickButtonOnwards(){
        driver.findElement(onwards).click();
    }
    public void setDeliveryDate(String date) {
        driver.findElement(deliveryDate).click();
        driver.findElement(deliveryDate).sendKeys(date);
        driver.findElement(selectDate).click();
    }

    public void setRentalPeriod(String period) {
        driver.findElement(rentalPeriod).click();
        List<WebElement> elements = driver.findElements(listRentalPeriod);
        for (int i=0; i< elements.size(); i++){
            WebElement element = elements.get(i);
            if (element.getText().equals(period)){
                element.click();
                break;
            }
        }
    }
    public void setColor(String color){
        if (color.equals(COLOR)){
            driver.findElement(blackColor).click();
        }
        else driver.findElement(greyColor).click();
    }
    public void setComment(String comment){
        driver.findElement(commentForCourier).sendKeys(comment);
    }

    public void doOrder(){
        driver.findElement(buttonOrder).click();
    }

    public void clickOrderConfirm(){
        driver.findElement(btnOrderConfirm).click();
    }

    public String orderSuccessful(){
        return driver.findElement(orderSuccessful).getText();
    }


}

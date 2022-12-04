package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebDriver driver;
    //JavascriptExecutor js = (JavascriptExecutor)driver;

    //Локатор кнопки закрытия плашки про куки
    private By closeCookie = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    //Первый вопрос из списка в разделе "Вопросы о важном"
    private By firstFAQ = By.xpath("//*[@id='accordion__heading-0']");

    //Второй вопрос из списка в разделе "Вопросы о важном"
    private By secondFAQ = By.xpath("//*[@id='accordion__heading-1']");

    //Ответ на первый вопрос из списка в разделе "Вопросы о важном"
    private By answerFirstFAQ = By.xpath("//*[@id='accordion__panel-0']/p");

    //Ответ на второй вопрос из списка в разделе "Вопросы о важном"
    private By answerSecondFAQ = By.xpath("//*[@id='accordion__panel-1']/p");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCloseCookie() {
        driver.findElement(closeCookie).click();
    }

    public void clickRoadMapOrderButton() {
        WebElement elRoadMapOrder = driver.findElement(firstFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elRoadMapOrder);
        elRoadMapOrder.click();
    }

    public void clickFirstFAQButton() {
        WebElement elFirstFAQ = driver.findElement(firstFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elFirstFAQ);
        elFirstFAQ.click();

    }

    public void clickSecondFAQButton() {
        WebElement elSecondFAQ = driver.findElement(secondFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elSecondFAQ);
        elSecondFAQ.click();
    }

    public String getTextAnswerFirstFAQ() {
        clickFirstFAQButton();
        return driver.findElement(answerFirstFAQ).getText();
    }

    public String getTextAnswerSecondFAQ() {
        clickSecondFAQButton();
        return driver.findElement(answerSecondFAQ).getText();
    }

}

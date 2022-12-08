package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebDriver driver;
//    private WebDriverWait wait;
//    private WebElement exampleElement;
    //JavascriptExecutor js = (JavascriptExecutor)driver;

    //Локатор кнопки закрытия плашки про куки
    private By closeCookie = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    //Первый вопрос из списка в разделе "Вопросы о важном"
    private By firstFAQ = By.xpath("//*[@id='accordion__heading-0']");

    //Второй вопрос из списка в разделе "Вопросы о важном"
    private By secondFAQ = By.xpath("//*[@id='accordion__heading-1']");

    //Третий вопрос из списка в разделе "Вопросы о важном"
    private By thirdFAQ = By.xpath("//*[@id='accordion__heading-2']");

    //Четвертый вопрос из списка в разделе "Вопросы о важном"
    private By fourthFAQ = By.xpath("//*[@id='accordion__heading-3']");

    //Пятый вопрос из списка в разделе "Вопросы о важном"
    private By fifthFAQ = By.xpath("//*[@id='accordion__heading-4']");

    //Шестой вопрос из списка в разделе "Вопросы о важном"
    private By sixthFAQ = By.xpath("//*[@id='accordion__heading-5']");

    //Седьмой вопрос из списка в разделе "Вопросы о важном"
    private By seventhFAQ = By.xpath("//*[@id='accordion__heading-6']");

    //Восьмой вопрос из списка в разделе "Вопросы о важном"
    private By eighthFAQ = By.xpath("//*[@id='accordion__heading-7']");

    //Ответ на первый вопрос из списка в разделе "Вопросы о важном"
    private By answerFirstFAQ = By.xpath("//*[@id='accordion__panel-0']/p");

    //Ответ на второй вопрос из списка в разделе "Вопросы о важном"
    private By answerSecondFAQ = By.xpath("//*[@id='accordion__panel-1']/p");

    //Ответ на третий вопрос из списка в разделе "Вопросы о важном"
    private By answerThirdFAQ = By.xpath("//*[@id='accordion__panel-2']/p");

    //Ответ на четвертый вопрос из списка в разделе "Вопросы о важном"
    private By answerFourthFAQ = By.xpath("//*[@id='accordion__panel-3']/p");

    //Ответ на пятый вопрос из списка в разделе "Вопросы о важном"
    private By answerFifthFAQ = By.xpath("//*[@id='accordion__panel-4']/p");

    //Ответ на шестой вопрос из списка в разделе "Вопросы о важном"
    private By answerSixthFAQ = By.xpath("//*[@id='accordion__panel-5']/p");

    //Ответ на седьмой вопрос из списка в разделе "Вопросы о важном"
    private By answerSeventhFAQ = By.xpath("//*[@id='accordion__panel-6']/p");

    //Ответ на восьмой вопрос из списка в разделе "Вопросы о важном"
    private By answerEighthFAQ = By.xpath("//*[@id='accordion__panel-7']/p");


    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickCloseCookie() {
        driver.findElement(closeCookie).click();
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
    public void clickThirdFAQButton() {
        WebElement elThirdFAQ = driver.findElement(thirdFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elThirdFAQ);
        elThirdFAQ.click();
    }
    public void clickFourthFAQButton() {
        WebElement elFourthFAQ = driver.findElement(fourthFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elFourthFAQ);
        elFourthFAQ.click();
    }
    public void clickFifthFAQButton() {
        WebElement elFifthFAQ = driver.findElement(fifthFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elFifthFAQ);
        elFifthFAQ.click();

    }
    public void clickSixthFAQButton() {
        WebElement elSixthFAQ = driver.findElement(sixthFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elSixthFAQ);
        elSixthFAQ.click();
    }
    public void clickSeventhFAQButton() {
        WebElement elSeventhFAQ = driver.findElement(seventhFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elSeventhFAQ);
        elSeventhFAQ.click();
    }
    public void clickEighthFAQButton() {
        WebElement elEighthFAQ = driver.findElement(eighthFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elEighthFAQ);
        elEighthFAQ.click();
    }

    public String getTextAnswer(int numQuestion){
        if(numQuestion == 1){
            clickFirstFAQButton();
            return driver.findElement(answerFirstFAQ).getText();
        }
        if (numQuestion == 2){
            clickSecondFAQButton();
            return driver.findElement(answerSecondFAQ).getText();
        }
        if (numQuestion == 3){
            clickThirdFAQButton();
            return driver.findElement(answerThirdFAQ).getText();
        }
        if (numQuestion == 4){
            clickFourthFAQButton();
            return driver.findElement(answerFourthFAQ).getText();
        }
        if (numQuestion == 5){
            clickFifthFAQButton();
            return driver.findElement(answerFifthFAQ).getText();
        }
        if (numQuestion == 6){
            clickSixthFAQButton();
            return driver.findElement(answerSixthFAQ).getText();
        }
        if (numQuestion == 7){
            clickSeventhFAQButton();
            return driver.findElement(answerSeventhFAQ).getText();
        }
        if (numQuestion == 8){
            clickEighthFAQButton();
            return driver.findElement(answerEighthFAQ).getText();
        }
        return "Вопрос не найден";
    }




}

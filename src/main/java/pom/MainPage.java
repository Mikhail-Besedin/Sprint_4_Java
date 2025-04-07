package pom;
import org.openqa.selenium.*;
import static java.lang.String.format;
import static pom.OrderPage.titleHomeLocator;


public class MainPage extends BasePage {

    //аккордион вопроса
    public static final String questionLocator = "//*[@id='accordion__heading-%d']";// Используем %d как маркер для целого числа
    //аккордион ответа
    public static final  String answerLocator = "//*[@id='accordion__panel-%d']";// Используем %d как маркер для целого числа
    //Вопросы о важном
    public static final  By blockOfQuestionLocator = By.xpath("//*[contains(@class, 'Home_FourPart')]");
    //Кнопка Заказать в хедере
    public static final  By headerOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    //Кнопка заказать в середине
    public static final  By orderDownButton= By.xpath( ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка Куки
    public static final By cookieAcceptButton = By.id("rcc-confirm-button");


    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }



// формаритруем локатор , проставляем в него номер ответа
    public By formatLocatorsAnswer(int num){
        return By.xpath(format(answerLocator, num));}

// формаритруем локатор , проставляем в него номер вопроса
    public By formatLocatorsQuestion(int num){
        return By.xpath(format(questionLocator, num));}


//Получаем текст ответа
    public String getAnswerText(int num ) {
        scrollToElement(formatLocatorsQuestion(num));
        clickToElement(formatLocatorsQuestion(num));
        return getTextFromElement(formatLocatorsAnswer(num));}

// Кликаем на кнопку "Заказать" в хедере и получаем текст в описании заголовка
    public String clickHeaderOrderButton(){
        clickToElement(headerOrderButton);
            return getTextFromElement(titleHomeLocator);}

//Кликаем на кнопку "Заказать" внизу страницы и получаем текст в описании заголовка
    public String clickOrderDownButton() {
        scrollToElement(blockOfQuestionLocator);
        clickToElement(orderDownButton);
            return getTextFromElement(titleHomeLocator);}


//Кликаем на кнопку "Да все привыкли"
    public void clickOnCookieAcceptButton() {
        clickToElement(cookieAcceptButton);
    }

}









package pom;
import org.openqa.selenium.*;

public class OrderPage extends BasePage {

    //локатор поля Имя
    public static final By nameLocator= By.xpath( "// input[@placeholder = '* Имя']");
    //локатор поля фамилия
    public static final By lastNameLocator = By.xpath("//input[@placeholder = '* Фамилия']");
    //локатор поля адрес
    public static final By addressLocator = By.xpath("//input[@placeholder = '* Адрес: куда привезти заказ']");
    //локатор поля станция метро
    public static final By stationButtonLocator = By.xpath("//input[@placeholder = '* Станция метро']");
    //локатор элемента списка Парк культуры
    public static final By addStationLocator = By.xpath("//div[text() = 'Парк культуры']");
    //локатор поля телефон
    public static final By telLocator = By.xpath("//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //локатор кнопки далее
    public static final By nextButtonLocator = By.xpath("//*[text() = 'Далее']");
    //локатор кнопки  Когда привезти самокат
    public static final By dateButtonLocator = By.xpath("//input[@placeholder = '* Когда привезти самокат']");
    //локатор кнопки в каледаре 30 апреля 2025
    public static final By dayButtonLocator = By.xpath("//div[@aria-label='Choose среда, 30-е апреля 2025 г.']");
    //локатор поля срок аренды
    public static final By rentalPeriodButtonLocator = By.xpath("//div[@class ='Dropdown-root']");
    //локатор элемента "двое суток" из списка срок аренды
    public static final By periodButtonLocator = By.xpath("//*[text() = 'двое суток']");
    //Локатор чекбокса черного цвета
    public static final By colorButtonLocator = By.xpath("//input[@id='black']");
    //Локатор поля Комментарий для курьера
    public static final By commentsButtonLocator = By.xpath("//input[@placeholder = 'Комментарий для курьера']");
    //Локатор кнопки заказать под формой заказа
    public static final By orderButtonLocator = By.cssSelector("div[class='Order_Buttons__1xGrp']>button:nth-child(2)");
    //Локатор надписи в окне при успешном завершении заказа
    public static final By orderModalHeaderLocator = By.xpath("//*[contains(@class,'Order_ModalHeader__3FDaJ')]"); // Заголовок в всплывающем окне
    //Локатор кнопки Да в при оформлении заказа
    public static final By yesButtonLocator = By.xpath("//button[text() = 'Да']");
    //Локатор надписи Для кого самокат
    public static final  By titleHomeLocator = By.xpath("//*[contains(@class,'Order_Header__BZXOb')]");


    public OrderPage(WebDriver webDriver) {
        super(webDriver);
    }

//Заполняем данные на странице "для кого самокат" и кликаем на кнопку "Далее"
    public void  setOrderToTheNextButton( String name, String last_name,String adress,String text,String tel){
        addTextToElement(nameLocator,name);
        addTextToElement(lastNameLocator,last_name);
        addTextToElement(addressLocator,adress);
        addTextToElement(stationButtonLocator,text);
        clickToElement(addStationLocator);
        addTextToElement(telLocator,tel);
        clickToElement(nextButtonLocator);}


//Заполняем данные на странице "Про аренду" и кликаем на кнопку "Заказать
    public void setOrderToTheOrderButton( String data,String comment) {
        addTextToElement(dateButtonLocator,data);
        clickToElement(dayButtonLocator);
        clickToElement(rentalPeriodButtonLocator);
        clickToElement(periodButtonLocator);
        clickToElement(colorButtonLocator);
        addTextToElement(commentsButtonLocator,comment);
        clickToElement(orderButtonLocator);
        clickToElement(yesButtonLocator);}

//Получаем текст из страницы  после оформления заказа
    public String pageSetOrder() {
        return getTextFromElement(orderModalHeaderLocator);}

}
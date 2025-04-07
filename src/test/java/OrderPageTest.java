import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.MainPage;
import pom.OrderPage;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class OrderPageTest {
    private static WebDriver webDriver;
    private final  String name;
    private final  String lastName;
    private final  String adress;
    private final  String tel;
    private final  String comment;

    @Before
    public void setup() {
        webDriver = new ChromeDriver();}


    public OrderPageTest(String name, String lastName, String adress, String tel, String comment) {
        this.name = name;
        this.lastName = lastName;
        this.adress = adress;
        this.tel = tel;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] makeOrder(){
        return new Object[][]{
                {"Анна", "Беседина", "Краснокурсантская 88 ", "89992223344", "первый прогон"},
                {"Михаил", "Беседин", "Каснокупеческая 99 ", "89993335577", "второй прогон"},};
    }

//    Тест оформления заказа по клику на кнопку 'Заказать' в хедере"
//    1)на главной странице в хедере кликаем на кнопку "Заказать";
//    2)Заполняем данные на странице "для кого самокат' и кликаем на кнопку "Далее";
//    3)Заполняем данные "Про аренду" и кликаем на кнопку "Заказать";
//    4)Подтверждаем заказ и проверяем открытие окна с текстом оформления заказа
    @Test
    public void testPlaceAnOrder() {
        OrderPage orderPage = new OrderPage(webDriver);
        MainPage mainPage = new MainPage(webDriver);
        orderPage.open();
        mainPage.clickOnCookieAcceptButton();
        mainPage.clickHeaderOrderButton();
        orderPage.setOrderToTheNextButton(name, lastName, adress, Data.nameStation, tel);
        orderPage.setOrderToTheOrderButton(Data.dayDelivery,comment);
        assertEquals("Заказ оформлен", orderPage.pageSetOrder());}



    @After
    public void tearDown() {
        webDriver.quit();
    }
}

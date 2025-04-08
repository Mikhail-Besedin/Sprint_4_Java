

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.MainPage;
import static org.junit.Assert.assertEquals;




@RunWith(Parameterized.class)



//Тест проверки текста ответов на вопросы на главной странице веб-приложения
//1)Скроллим до блока с вопросами
//2)Кликаем на вопрос
//3)Получаем текст ответа на выбранный вопрос
//4)Сравниваем полученный текст с ожидаемым
public class MainPageTest {
    private static WebDriver webDriver;
    private final  int num;
    private final  String result;

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
    }

    public MainPageTest(int num, String result) {
        this.num = num;
        this.result = result;
    }
    @Parameterized.Parameters
    public static Object[][] getInformationQuestions(){
        return new Object[][]{
            {0, Data.answerText0},
            {1, Data.answerText1},
            {2, Data.answerText2},
            {3, Data.answerText3},
            {4, Data.answerText4},
            {5, Data.answerText5},
            {6, Data.answerText6},
            {7, Data.answerText7},};
            }
    @Test
    public void compareAnswersWithText() {

        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();

        String actualResult = mainPage.getAnswerText(num);
        assertEquals(result, actualResult);}




    @After
        public void tearDown() {
        webDriver.quit();
        }
    }
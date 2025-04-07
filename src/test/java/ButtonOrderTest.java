import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.MainPage;

import static org.junit.Assert.assertEquals;

public class ButtonOrderTest {
    private static WebDriver webDriver;



    @Before
    public void setup() {
        webDriver = new ChromeDriver();
    }


    @Test
    public void testOrderButtonHead() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        assertEquals("Для кого самокат", mainPage.clickHeaderOrderButton());
    }

    @Test
    public void testOrderButtonMiddle() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        assertEquals("Для кого самокат", mainPage.clickOrderDownButton());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

}
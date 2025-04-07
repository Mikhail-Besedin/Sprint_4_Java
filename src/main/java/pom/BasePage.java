package pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class BasePage {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get(URL);
    }

    // Скролим до элемента
    public void scrollToElement(By locator) {
        WebElement element = webDriver.findElement(locator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Находим элемент применяя ожидание, чтобы элемент стал видимым
    public WebElement findElementWithWait(By locator) {
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webDriver.findElement(locator);
    }

    // Кликаем на элемент применяя ожидание, чтобы элемент стал кликабельным
    public void clickToElement(By locator) {
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(locator));
        webDriver.findElement(locator).click();
    }

    // Добавляем текст в  элемент применяя ожидание, чтобы элемент стал видимым
    public void addTextToElement(By locator, String text) {
        WebElement element = findElementWithWait(locator);
        element.sendKeys(text);
    }

    // Получаем текст в  элементе применяя ожидание, чтобы элемент стал видимым
    public String getTextFromElement(By locator) {
        WebElement element = findElementWithWait(locator);
        return element.getText();
    }
}


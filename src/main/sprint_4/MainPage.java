package main.sprint_4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    public static By TOP_ORDER_BUTTON = By.xpath("//div[contains(@class, 'Header_Nav__AGCXC')]//button[contains(@class, 'Button_Button__ra12g')]");
    public static By BOTTOM_ORDER_BUTTON = By.xpath("//div[contains(@class, 'Home_FinishButton__1_cWm')]//button[contains(@class, 'Button_Button__ra12g')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickButton(By buttonSelector) {
        WebElement element = driver.findElement(buttonSelector);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
}

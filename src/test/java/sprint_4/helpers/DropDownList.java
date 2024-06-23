package sprint_4.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDownList {
    public WebDriver driver;

    public DropDownList(WebDriver driver) {
        this.driver = driver;
    }

    private String dropDownItems = "accordion__heading-%d";
    private String dropDownText = "accordion__panel-%d";
    int itemIndex;
    String expectedText;

    public void clickDropDownItems(int itemIndex) throws InterruptedException {
       Thread.sleep(10000);
        WebElement element = driver.findElement(By.className("Home_FourPart__1uthg"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        getFromDropItem(itemIndex).click();
    }

    public String getTextFromDropItems(int itemIndex) {
        return driver.findElement(By.id(String.format(dropDownText, itemIndex))).getText();
    }
    public WebElement getFromDropItem(int itemIndex) {
        return driver.findElement(By.id(String.format(dropDownItems, itemIndex)));
    }
}


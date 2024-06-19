package main.sprint_4;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}

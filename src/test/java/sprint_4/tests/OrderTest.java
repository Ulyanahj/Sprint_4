
package sprint_4.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sprint_4.helpers.MainPage;
import sprint_4.helpers.OrderPage;


@RunWith(Parameterized.class)
public class OrderTest {
    WebDriver driver;

    private By buttonSelector;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("120.0.6099.71").setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }


    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {MainPage.TOP_ORDER_BUTTON},
                {MainPage.BOTTOM_ORDER_BUTTON},
        };
    }
    public OrderTest(By buttonSelector) {
        this.buttonSelector = buttonSelector;
    }

    @Test
    public void orderPage() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        mainPage.clickButton(buttonSelector);
        orderPage.fillFirstOrderForm("Вася", "Пупкин", "к подъезду", "Черкизовская", "+71234567890");
        orderPage.fillSecondOrderForm("11.11.2014");
        orderPage.confirmOrder();

        Assert.assertNull(orderPage.getConfirmOrderButton());
    }


    @After
    public void cleanUp() {
        driver.quit();
    }


}



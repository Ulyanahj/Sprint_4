package main.sprint_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;


public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    final By nextButton = By.xpath(".//button[text()='Далее']");  //локатор для кнопки Далее
    private By nameField = By.xpath(".//*[@placeholder='* Имя']"); // локатор для поля Имя
    private By surnameField = By.xpath(".//*[@placeholder='* Фамилия']");  // локатор для поля Фамилия
    private By addressField = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");  // локатор для поля Адрес
    private By metroStationField = By.xpath(".//*[@placeholder='* Станция метро']");  // локатор для поля Станция метро
    private By phoneNumberField = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']"); // локатор для поля Телефон
    private By dateField = By.xpath(".//*[@placeholder='* Когда привезти самокат']"); // локатор для даты
    private By rentalPeriodParent  = By.className("Dropdown-root"); //локатор для аренды, выпадающий список
    private By rentalPeriodElement  = By.className("Dropdown-option"); //локатор элемент из списка аренды
    final By orderButton = By.xpath("//div[contains(@class, 'Order_Buttons__1xGrp')]//button[text()='Заказать']");  //локатор для кнопки Далее
    final By confirmButton = By.xpath("//div[contains(@class, 'Order_Buttons__1xGrp')]//button[text()='Да']");  //локатор для кнопки Далее

    public void fillFirstOrderForm(String name, String surname, String address, String metroStation, String phoneNumber) { //создание первой формы
        driver.findElement(nameField).sendKeys(name);                 //заполнение полей
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        WebElement metroSelector = driver.findElement(metroStationField);   // нвшли элемент списка станции=й
        metroSelector.sendKeys(metroStation);                              // ввели название станции
        metroSelector.sendKeys(Keys.ARROW_DOWN);                           // кнопка вниз
        metroSelector.sendKeys(Keys.ENTER);                                //клик на enter
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        driver.findElement(nextButton).click();
    }

    public void fillSecondOrderForm(String date) {
        WebElement dateElement = driver.findElement(dateField);
        dateElement.sendKeys(date);
        dateElement.sendKeys(Keys.ENTER);
        driver.findElement(rentalPeriodParent).click();
        driver.findElement(rentalPeriodElement).click();
        driver.findElement(orderButton).click();
    }

    public void confirmOrder() {
        getConfirmOrderButton().click();
    }

    public WebElement getConfirmOrderButton() {
        return driver.findElement(confirmButton);
    }
}

//        setName(name);
//        setSurname(surname);
//        setAddress(address);
//        setMetroStation(metroStation);
//        setPhoneNumber(phoneNumber);
//        clickOrderUpButton();


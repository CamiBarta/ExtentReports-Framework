package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected String url = "https://automationtesting.co.uk/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToUrl() {
        driver.get(url);
    }

    public void click(By element) {
        driver.findElement(element).click();
    }

    public void setText(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    public String getText(By element) {
        return driver.findElement(element).getText();
    }
}

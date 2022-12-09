package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingMethodPage extends BasePage {

    public ShippingMethodPage(WebDriver driver) {
        super(driver);
    }

    public void continueBtn(){
        click(By.cssSelector("[name='confirmDeliveryOption']"));
    }
}

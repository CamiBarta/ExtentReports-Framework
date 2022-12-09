package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage{

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void payByCheck(){
        click(By.xpath("//span[.='Pay by Check']"));
    }

    public void agreeToTerms(){
        click(By.xpath("//input[@id='conditions_to_approve[terms-and-conditions]']"));
    }

    public void orderBtn(){
        click(By.xpath("//div[@id='payment-confirmation']//button[@type='submit']"));
    }
}

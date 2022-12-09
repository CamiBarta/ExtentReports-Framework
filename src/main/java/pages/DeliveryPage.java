package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DeliveryPage extends BasePage {

    public DeliveryPage(WebDriver driver) {
        super(driver);
    }

    public void inputDataInAddressFields() {
        setText(By.cssSelector("input[name='address1']"),"Frog Street" );
        setText(By.cssSelector("input[name='city']"), "Los Angeles");
        Select option=new Select(driver.findElement(By.cssSelector("select[name='id_state']")));
        option.selectByVisibleText("California");
        setText(By.cssSelector("input[name='postcode']"),"12345");
    }

    public void clickContinueBtn(){
        click(By.cssSelector("button[name='confirm-addresses']"));
    }
}

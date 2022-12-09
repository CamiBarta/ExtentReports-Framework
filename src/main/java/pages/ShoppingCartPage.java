package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void promoCode(){
        click(By.cssSelector(".promo-code-button .collapse-button"));
        setText(By.cssSelector("input[name='discount_name']"),"20OFF");
        click(By.cssSelector("form[method='post']  span"));
    }

    public void proceedToCheckoutBtn(){
        click(By.cssSelector(".cart-detailed-actions .btn-primary"));
    }
}

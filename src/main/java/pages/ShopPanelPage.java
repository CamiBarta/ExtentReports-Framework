package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPanelPage extends BasePage {

    public ShopPanelPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout() {
        click(By.cssSelector
                ("a[href='//teststore.automationtesting.co.uk/cart?action=show'][class='btn btn-primary']"));
    }
}

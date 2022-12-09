package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductShopPage extends BasePage {

    public ProductShopPage(WebDriver driver) {
        super(driver);
    }

    public void getSize() {
        Select option=new Select(driver.findElement(By.cssSelector("#group_1")));
        option.selectByVisibleText("M");
    }

    public void chooseColor(){
        click(By.xpath("(//input[@class='input-color'])[2]"));
    }

    public void increaseQuantity(){
        click(By.cssSelector(".material-icons.touchspin-up"));
    }

    public void addItemToCart(){
        click(By.cssSelector(".add-to-cart.btn.btn-primary"));
    }
}

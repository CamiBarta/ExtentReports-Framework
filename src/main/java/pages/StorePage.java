package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void selectItemToBuy() {
        click(By.xpath("//img[@alt='Hummingbird printed t-shirt']"));
    }
}

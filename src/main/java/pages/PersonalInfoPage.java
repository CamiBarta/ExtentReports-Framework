package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalInfoPage extends BasePage {

    public PersonalInfoPage(WebDriver driver) {
        super(driver);
    }

    public void inputDataInFields() {
        click(By.cssSelector("input[value='2']"));
        setText(By.cssSelector("input[name='firstname']"), "Cami");
        setText(By.cssSelector("input[name='lastname']"), "Nic");
        setText(By.cssSelector("form#customer-form > section input[name='email']"), "caminic@test.com");
        click(By.cssSelector("input[name='psgdpr']"));
    }

    public void clickContinueButton() {
        click(By.cssSelector("form#customer-form  button[name='continue']"));
    }
}

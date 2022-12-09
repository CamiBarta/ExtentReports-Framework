package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderCompleteTests extends BaseTests {

    @Test
    public void EndToEndTest() throws InterruptedException {

        createTests("orderCompleteTest");

        homePage.goToTestStore();

        storePage.selectItemToBuy();

        productShopPage.getSize();
        productShopPage.chooseColor();
        productShopPage.increaseQuantity();
        productShopPage.addItemToCart();
        Thread.sleep(5000);

        shopPanelPage.proceedToCheckout();
        Thread.sleep(5000);

        shoppingCartPage.promoCode();
        shoppingCartPage.proceedToCheckoutBtn();
        Thread.sleep(5000);

        personalInfoPage.inputDataInFields();
        personalInfoPage.clickContinueButton();
        Thread.sleep(5000);

        deliveryPage.inputDataInAddressFields();
        deliveryPage.clickContinueBtn();
        Thread.sleep(5000);

        shippingMethodPage.continueBtn();
        Thread.sleep(5000);

        paymentPage.payByCheck();
        paymentPage.agreeToTerms();
        paymentPage.orderBtn();
        Thread.sleep(5000);

        String actualMessage = basePage.getText(By.xpath("//h3[@class='h1 card-title']"));
        System.out.println(actualMessage);
        Assert.assertTrue(actualMessage.contains("YOUR ORDER IS CONFIRMED"), "The message is not the same");
    }
}

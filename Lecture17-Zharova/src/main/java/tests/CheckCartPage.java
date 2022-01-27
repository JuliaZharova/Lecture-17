package tests;

import PageObject.CartPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static PageObject.BasePage.driver;

@Listeners(PageObject.Listener.class)
public class CheckCartPage{

    @Test(groups = {"cart"})
    public void checkAddItemToCard(){
        WebDriverManager.chromedriver().setup();
        new CartPage(new ChromeDriver())
                .openProductPage()
                .getProductName()
                .checkBuyButtonIsDisplayed()
                .clickOnBuyButton()
                .checkNameCart()
                .checkPopupCartIsDisplayed()
                .checkTextOnContinueShoppingButton()
                .checkTextOnPlaceAnOrderButton()
                .checkCartProductTitleIsDisplayed().
                checkCartProductTitleEqualsProductName();
    }

    @Test (groups = {"cart"})
    public void checkRemoveItemFromCart(){
        WebDriverManager.chromedriver().setup();
        new CartPage(new ChromeDriver())
                .openProductPage()
                .checkBuyButtonIsDisplayed()
                .clickOnBuyButton()
                .checkNameCart()
                .checkPopupCartIsDisplayed()
                .checkCartProductTitleIsDisplayed()
                .checkThreeDotsButtonIsDisplayed()
                .clickOnThreeDotsButton()
                .checkTextOnRemoveButton()
                .clickOnRemoveButton()
                .checkCartImageIsDisplayed()
                .checkTitleCartIsEmpty();
    }

    @AfterMethod
    public void setDown() {
        driver.quit();
    }
}

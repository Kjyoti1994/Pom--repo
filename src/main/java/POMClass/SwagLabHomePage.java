package POMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage 
{
@FindBy(xpath="//button[text()='Open Menu']") private WebElement Menu;
@FindBy(xpath="(//button[text()='Add to cart'])[1]") private WebElement AddToCart;
@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement CartLogo;
WebDriver driver;
public SwagLabHomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	this.driver=driver;
}

public void clickSwagLabHomePageAddToCartBtn() {
	AddToCart.click();
}

public void clickSwagLabHomePageCartLogo() {
	CartLogo.click();
}

public String SwagLabHomePageTitle() {
	String actTitle = driver.getTitle();
	return actTitle;
}
public void clickSwagLabHomePageMenuBtn() {
	Menu.click();
}
}

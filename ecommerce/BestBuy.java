package ecommerce;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BestBuy {
	private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
    }
    @Test
    public void testOpenBestBuyWebsite() {
        driver.get("https://www.bestbuy.com/");
        Assert.assertEquals(driver.getTitle(), "Best Buy | Official Online Store | Shop Now & Save");
    }
    @Test
    public void testValidateURL() {
        
        String urlToValidate = "https://www.bestbuy.com/";
        int statusCode = getResponseStatus(urlToValidate);
        Assert.assertEquals(statusCode, 200, "URL is broken!");
    }
	
	
	 private int getResponseStatus(String urlToValidate) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Test(priority = 1)
		    public void clickSignIn() {
		        WebElement signInButton = driver.findElement(By.id("profileMenuWrap1"));
		        signInButton.click();
		    }

		    @Test(priority = 2)
		    public void clickCreateAccount() {
		        WebElement createAccountButton = driver.findElement(By.linkText("Create Account"));
		        createAccountButton.click();
		    }

		    @Test(priority = 3)
		    public void signUp() {
		        WebElement firstName = driver.findElement(By.id("fld-firstName"));
		        WebElement lastName = driver.findElement(By.id("fld-lastName"));
		        WebElement email = driver.findElement(By.id("fld-e"));
		        WebElement password = driver.findElement(By.id("fld-p1"));
		        firstName.sendKeys("Mounika");
		        lastName.sendKeys("Pasupuletu");
		        email.sendKeys("saimounikapasupuleti@gmail.com");
		        password.sendKeys("M@12345");

		         password.submit();
		    
	}
		    @Test
		    public void navigateAndValidateTitles() {
		        List<WebElement> menuItems = driver.findElements(By.xpath("//nav[@id='header-nav']//a[contains(@class, 'menu-item')]"));
		        
		        for (WebElement menuItem : menuItems) {
		            
		            menuItem.click();
		            String pageTitle = driver.getTitle();
  
		            Assert.assertTrue(pageTitle.contains("Best Buy"), "Page title doesn't contain 'Best Buy'");

		            driver.navigate().back();
		        }
		    }

		    @Test
		    public void validateBottomLinks() {
		     
		        WebElement footer = driver.findElement(By.xpath("//footer")); 
		        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
		        for (WebElement link : footerLinks) {  
		            link.click();

		            String pageTitle = driver.getTitle();

		            Assert.assertTrue(pageTitle.contains("Best Buy"), "Page title doesn't contain 'Best Buy'");

		            driver.navigate().back();
		        }
		    }
		    
		    @Test
		    public void searchAndAddToCart() {
		        
		        WebElement searchBox = driver.findElement(By.id("gh-search-input"));
		        searchBox.sendKeys("laptop");
		        searchBox.sendKeys(Keys.RETURN);

		        
		        WebElement firstResult = driver.findElement(By.xpath("//div[@class='sku-title']/a"));
		        String productName = firstResult.getText();
		        firstResult.click();

		        
		        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(@class, 'add-to-cart-button')]"));
		        addToCartButton.click();

		        WebElement cartItem = driver.findElement(By.xpath("//div[@class='cart-item-title']/a"));
		        String cartItemName = cartItem.getText();
		        Assert.assertEquals(cartItemName, productName, "Item in the cart does not match the selected product");
		    }
		    @Test
		    public void selectAndAddItemFromShopByDepartment() {
	
		        WebElement shopByDepartmentMenu = driver.findElement(By.xpath("//button[@data-type='link'][contains(text(),'Shop by Department')]"));
		        shopByDepartmentMenu.click();

		        WebElement computersTabletsLink = driver.findElement(By.xpath("//a[text()='Computers & Tablets']"));
		        computersTabletsLink.click();

		        WebElement laptopsLink = driver.findElement(By.xpath("//a[text()='Laptops']"));
		        laptopsLink.click();

		        WebElement firstItem = driver.findElement(By.xpath("//div[@class='sku-title']/a"));
		        String itemName = firstItem.getText();
		        firstItem.click();
		         firstItem = driver.findElement(By.xpath("//div[@class='sku-title']/a"));
		         itemName = firstItem.getText();
		        firstItem.click();

		        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(@class, 'add-to-cart-button')]"));
		        addToCartButton.click();

		        
		       // WebDriverWait wait = new WebDriverWait(driver, 10);
		       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'cart-item-count')]")));

		        
		        driver.get("https://www.bestbuy.com/cart");
		        WebElement cartItem = driver.findElement(By.xpath("//div[@class='cart-item-title']/a"));
		        String cartItemName = cartItem.getText();
		        Assert.assertEquals(cartItemName, itemName, "Item in the cart does not match the selected product");
		    }
		    @Test
		    public void selectAndAddItemFromBrandsMenu() {
		
		        WebElement brandsMenu = driver.findElement(By.xpath("//button[@data-type='link'][contains(text(),'Brands')]"));
		        brandsMenu.click();

		        WebElement sonyBrandLink = driver.findElement(By.xpath("//a[text()='Sony']"));
		        sonyBrandLink.click();

		        WebElement firstItem = driver.findElement(By.xpath("//div[@class='sku-title']/a"));
		        String itemName = firstItem.getText();
		        firstItem.click();

		        
		        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(@class, 'add-to-cart-button')]"));
		        addToCartButton.click();
		      //  WebDriverWait wait = new WebDriverWait(driver, 10);
		       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'cart-item-count')]")));

		        
		        driver.get("https://www.bestbuy.com/cart");
		        WebElement cartItem = driver.findElement(By.xpath("//div[@class='cart-item-title']/a"));
		        String cartItemName = cartItem.getText();
		        Assert.assertEquals(cartItemName, itemName, "Item in the cart does not match the selected product");
		    }
		    @Test(priority = 1)
		    public void navigateToCheckout() {
		        
		        WebElement cartIcon = driver.findElement(By.xpath("//span[contains(@class, 'cart-item-count')]"));
		        cartIcon.click();

		        
		        WebElement goToCartButton = driver.findElement(By.xpath("//a[contains(@class, 'go-to-cart')]"));
		        goToCartButton.click();

		        
		        WebElement checkoutButton = driver.findElement(By.xpath("//button[contains(@class, 'btn-primary')]"));
		        checkoutButton.click();
		    }
		    @Test(priority = 2)
		    public void fillOutCheckoutForm() {
		        
		        WebElement firstNameField = driver.findElement(By.id("first name"));
		        firstNameField.sendKeys("Mounika");

		        WebElement lastNameField = driver.findElement(By.id("lastName"));
		        lastNameField.sendKeys("Pasupuleti");

		        
		        WebElement continueToPaymentButton = driver.findElement(By.xpath("//button[contains(@class, 'btn-primary')]"));
		        continueToPaymentButton.click();
		    }
		    @Test(priority = 3)
		    public void fillOutPaymentInformation() {
		        
		        WebElement creditCardField = driver.findElement(By.id("creditCardNumber"));
		        creditCardField.sendKeys("1234567812345678");

		        WebElement expirationDateField = driver.findElement(By.id("expirationDate"));
		        expirationDateField.sendKeys("12/24");

		        
		        WebElement placeOrderButton = driver.findElement(By.xpath("//button[contains(@class, 'btn-primary')]"));
		        placeOrderButton.click();
		    }
		    @Test(priority = 4)
		    public void verifyOrderPlacement() {
		       
		        WebElement orderConfirmationMessage = driver.findElement(By.xpath("//div[contains(@class, 'order-confirmation-message')]"));
		        String confirmationText = orderConfirmationMessage.getText();
		        assert confirmationText.contains("Order Placed Successfully");
		    }
		    @AfterClass
		    public void tearDown() {
		        driver.quit();
		    }

		    
		    


}

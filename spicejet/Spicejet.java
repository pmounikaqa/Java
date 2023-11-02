package spicejet;
import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;


public class Spicejet {

	private WebDriver driver;
	

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");
    }
    @Test
    public void testSignUp() {
        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign up')]"));
        signUpLink.click();

        
        WebElement fullNameInput = driver.findElement(By.xpath("//input[@id='full-name']"));
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement confirmPasswordInput = driver.findElement(By.xpath("//input[@id='confirm-password']"));
        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(text(),'Sign up')]"));

        fullNameInput.sendKeys("Mounika");
        emailInput.sendKeys("saimounikapasupuleti@gmai.com");
        passwordInput.sendKeys("p@12345");
        confirmPasswordInput.sendKeys("p@12345");
        signUpButton.click();
    }

       // WebElement successMessage = driver.findElement(By.xpath("//div[@class='success-message']"));
        //Assert.assertTrue(successMessage.isDisplayed(), "Sign-Up was not successful");
        @Test
        public void testLogin() {
            
            WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
            loginButton.click();

            
			
           //  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("login-popup-frame"));

            
            WebElement usernameInput = driver.findElement(By.xpath("//input[@id='username']"));
            WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
            WebElement loginSubmitButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));

            
            usernameInput.sendKeys("Mounika_pasupuleti");
            passwordInput.sendKeys("P@12345");

            
            loginSubmitButton.click();

            
            driver.switchTo().defaultContent();
    }
        @Test
        public void testOneWayFlightSearch() {
            // Click on the one-way radio button (replace the following XPath with the actual one)
            WebElement oneWayRadio = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']"));
            oneWayRadio.click();

            // Select the departure and arrival cities (replace the following XPaths and values with the actual ones)
            WebElement fromCityInput = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
            fromCityInput.sendKeys("Delhi");
            WebElement toCityInput = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"));
            toCityInput.sendKeys("Mumbai");

            // Select the date (replace the following XPath and value with the actual ones)
            WebElement dateInput = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']"));
            dateInput.sendKeys("01-11-2023"); // Use the correct date format

            // Click on the search button
            WebElement searchButton = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']"));
            searchButton.click();

            // You can add validations/assertions for the search results if needed
            // ...

        }

        @Test
        public void testRoundTripFlightSearch() {
            
            WebElement roundTripRadio = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']"));
            roundTripRadio.click();

            
            WebElement fromCityInput = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
            fromCityInput.sendKeys("Delhi");
            WebElement toCityInput = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"));
            toCityInput.sendKeys("Mumbai");

            
            WebElement departureDateInput = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']"));
            departureDateInput.sendKeys("01-11-2023"); 
            WebElement returnDateInput = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']"));
            returnDateInput.sendKeys("05-11-2023"); 

           
            WebElement searchButton = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']"));
            searchButton.click();


        }

        @Test
        public void testSelectAndProceedToBooking() {
            

           
            WebElement selectFlightButton = driver.findElement(By.xpath("//button[@class='select-flight-button']"));
            selectFlightButton.click();

            
          //  WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='continueButton']")));

            
           // continueButton.click();

            WebElement passengerNameInput = driver.findElement(By.xpath("//input[@id='passengerName']"));
            passengerNameInput.sendKeys("Mounika pasupuleti");

            
            WebElement continueToPaymentButton = driver.findElement(By.xpath("//button[@id='continueToPayment']"));
            continueToPaymentButton.click();
        }

        @Test
        public void testFillBookingForm() {
            
            WebElement passengerNameInput = driver.findElement(By.xpath("//input[@id='passengerName']"));
            passengerNameInput.sendKeys("John Doe");

            WebElement emailInput = driver.findElement(By.xpath("//input[@id='email']"));
            emailInput.sendKeys("john.doe@example.com");

            WebElement phoneInput = driver.findElement(By.xpath("//input[@id='phone']"));
            phoneInput.sendKeys("1234567890");

            WebElement continueToPaymentButton = driver.findElement(By.xpath("//button[@id='continueToPayment']"));
            continueToPaymentButton.click();

            
           // WebElement cardNumberInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='cardNumber']")));
            //cardNumberInput.sendKeys("1234567890123456");

            WebElement expiryDateInput = driver.findElement(By.xpath("//input[@id='expiryDate']"));
            expiryDateInput.sendKeys("12/25");

            WebElement cvvInput = driver.findElement(By.xpath("//input[@id='cvv']"));
            cvvInput.sendKeys("123");

            WebElement completeBookingButton = driver.findElement(By.xpath("//button[@id='completeBooking']"));
            completeBookingButton.click();
        }

            @Test
            public void testVerifyBookingSuccess() {
               
              //  WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='confirmation-message']")));

               
                String expectedConfirmationMessage = "Your booking is confirmed!";
              //  String actualConfirmationMessage = confirmationMessage.getText();
               // Assert.assertEquals(actualConfirmationMessage, expectedConfirmationMessage, "Booking confirmation message mismatch");


        }
            @Test
            public void testCheckInPageValidation() {
                
                WebElement checkInLink = driver.findElement(By.xpath("//a[contains(text(),'Check-in')]"));
                checkInLink.click();

                
                WebElement checkInTitle = driver.findElement(By.xpath("//h1[contains(text(),'Check-in')]"));
                //Assert.assertTrue(checkInTitle.isDisplayed(), "Check-in page title is not displayed");

                

            }

            @Test
            public void testFlightStatusPageValidation() {
                
                WebElement flightStatusLink = driver.findElement(By.xpath("//a[contains(text(),'Flight Status')]"));
                flightStatusLink.click();

                
                WebElement flightStatusTitle = driver.findElement(By.xpath("//h1[contains(text(),'Flight Status')]"));
              //  Assert.assertTrue(flightStatusTitle.isDisplayed(), "Flight Status page title is not displayed");

               

            }

            @Test
            public void testManageBookingPageValidation() {
               
                WebElement manageBookingLink = driver.findElement(By.xpath("//a[contains(text(),'Manage Booking')]"));
                manageBookingLink.click();

              
                WebElement manageBookingTitle = driver.findElement(By.xpath("//h1[contains(text(),'Manage Booking')]"));
              //  Assert.assertTrue(manageBookingTitle.isDisplayed(), "Manage Booking page title is not displayed");


            }
            @AfterClass
            public void teardown() {
                driver.quit();
            }

}

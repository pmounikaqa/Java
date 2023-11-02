package spicejet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Jet {
	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromelatest\\chrome79\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");

		WebElement we=driver.findElement(By.xpath("//a[@id='highlight-book']"));
		Actions act=new Actions(driver);
		act.click(we).build().perform();
		WebElement we2=driver.findElement(By.xpath("//span[contains(text(),'Hotels')]"));
		Thread.sleep(5000);
		act.moveToElement(we2).click().build().perform();
		
		driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[7]")).click();
		
		
		String month="March 2020";
		String date="2";
		Thread.sleep(5000);

		
		while(true)										//div[@class='ui-datepicker-title']
		{
			String title=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			System.out.println(title);
			if(title.equals(month))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
		}
		List <WebElement> allDates=driver.findElements(By.xpath("//div[@id='ui-datepicker-div']//div[1]//table[1]//tbody[1]//tr//td//a[1]"));
		for(WebElement ele:allDates)
		{
			System.out.println(ele.getText());
			String dateValue=ele.getText();
			if(dateValue.equals(date))
			{
				ele.click();
				break;
			}
		}

		Select adult=new Select(driver.findElement(By.xpath("//select[@id='ddl_Adult_MST']")));
		adult.selectByVisibleText("2");
		
		Select child=new Select(driver.findElement(By.xpath("//select[@id='ddl_Child_MST']")));
		child.selectByVisibleText("2");
		
		Select infant=new Select(driver.findElement(By.xpath("//select[@id='ddl_Infant_MST']")));
		infant.selectByVisibleText("2");
	}

}

	

	
		



package testShopingCart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestAddedItems {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\MyWebDriverChrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String UN = "standard_user";
		String PW = "secret_sauce";
		driver.manage().window().maximize();
		driver.navigate().to("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(UN);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(PW);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		Thread.sleep(3000);
		int expectedItems = 6;
		List <WebElement> mybuttons = driver.findElements(By.className("btn"));
		//System.out.println(mybuttons.size());
		for (int i = 0; i<mybuttons.size();i++)
		{
			mybuttons.get(i).click();
		}
		
		String Number_added_in_ShoopingCart= driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
		//System.out.println(Number_added_in_ShoopingCart);
		int updated_Number_added_in_ShoopingCart = Integer.parseInt(Number_added_in_ShoopingCart);
		Assert.assertEquals(updated_Number_added_in_ShoopingCart, expectedItems);
		

		
		

	}

}

package Maven.Selemium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HowerOverActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:/AU/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		WebElement accounts = driver.findElement(By.id("nav-link-accountList"));
		act.moveToElement(accounts).build().perform();
		WebElement search_input = driver.findElement(By.xpath("//*[@id=\'twotabsearchtextbox\']"));
		// act.moveToElement(search_input).click().sendKeys("samsung
		// phones").sendKeys(Keys.ARROW_DOWN).build().perform();
		act.moveToElement(search_input).click().sendKeys("samsung phones").sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ENTER).build().perform();
		System.out.println("End of script statement");
		driver.quit();
	}

}
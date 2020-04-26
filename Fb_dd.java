package Maven.Selemium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Fb_dd {

	public static void main(String[] args) throws Exception {
		// Launch browser
		// System.setProperty("webdriver.gecko.driver",
		// "E:\\DriverServer\\geckodriver.exe");
		// WebDriver d=new FirefoxDriver();
		// d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\AU\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Load web page
		driver.get("https://www.facebook.com/");
		// DD
		Select dd = new Select(driver.findElement(By.id("month")));
		dd.selectByIndex(3);
		Thread.sleep(1000);
		dd.selectByValue("6");
		Thread.sleep(1000);
		dd.selectByVisibleText("Jul");
		Thread.sleep(1000);
		// Print selected option
		System.out.println("Selected options is:" + dd.getFirstSelectedOption().getText());
		Thread.sleep(3000);
		// close browser
		driver.quit();

	}

}

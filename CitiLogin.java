package Maven.Selemium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CitiLogin {

	public static void main(String[] args) throws InterruptedException {
		// Base Script for WebDriver:
		System.setProperty("webdriver.chrome.driver", "E:\\AU\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.online.citibank.co.in/");
		driver.findElement(By.xpath("//*[@id=\'loginId\']/img")).click();
		driver.navigate().to("https://www.citibank.co.in/ibank/login/IQPin1.jsp");
		Thread.sleep(2000);
		driver.findElement(By.id("User_Id")).sendKeys("VENKATESHAM");
		driver.findElement(By.id("password")).sendKeys("PASSWORDINPUT");
		driver.findElement(By.xpath("//*[@id=\'withKeyboard\']/div[1]/div/div[1]/div[3]/input")).click();
		driver.findElement(By.name("cPin_Id")).click();
		driver.findElement(By.xpath("//*[@id=\'skImg\']")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.name("password")).sendKeys("TESTPASSWORD");
		driver.findElement(
				By.xpath("//*[@id=\'main-wrapper\']/div/div[2]/div[2]/div[1]/div/div[2]/div[3]/div/div/span/a"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\'main-wrapper\']/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div[1]/div/div[2]/div[3]"))
				.click();
		System.out.println("Browser is being closed");
		driver.close();
	}

}

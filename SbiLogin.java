package Maven.Selemium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SbiLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\AU\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://retail.onlinesbi.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\'banking\']/div[1]/div/div/a[1]/span[1]")).click();
		// driver.findElement(By.className("login-new")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("continue_btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys("VENKATESH113");
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.xpath("//*[@id=\'username\']")).sendKeys("VEN113");
		driver.findElement(By.name("password")).sendKeys("VENKATESH");
		Thread.sleep(2000);
		driver.findElement(By.id("reset_btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\'navigation\']/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'banking\']/div[2]/div/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("CONTINUE TO LOGIN")).click();
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Test Completed");
	}

}

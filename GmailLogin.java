package Maven.Selemium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\AU\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://gmail.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("identifierId")).sendKeys("venkatesh113");
		driver.findElement(By.xpath("//*[@id=\'identifierNext\']/span/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input")).sendKeys("PASSWORD");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\'passwordNext\']/span/span")).click();
		System.out.println("Login Failed");
		driver.close();

	}

}

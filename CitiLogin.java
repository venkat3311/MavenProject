package Maven.Selemium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CitiLogin {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\AU\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.online.citibank.co.in/");
		driver.findElement(By.xpath("//*[@id=\'loginId\']/img")).click();
		driver.navigate().to("https://www.citibank.co.in/ibank/login/IQPin1.jsp");
		driver.findElement(By.id("User_Id")).sendKeys("VENKATESHAM");
		driver.findElement(By.id("password")).sendKeys("PASSWORDINPUT");
		driver.findElement(By.xpath("//*[@id=\'withKeyboard\']/div[1]/div/div[1]/div[3]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("cPin_Id")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\'skImg\']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.name("password")).sendKeys("TESTPASSWORD");
		driver.findElement(
				By.xpath("//*[@id=\'main-wrapper\']/div/div[2]/div[2]/div[1]/div/div[2]/div[3]/div/div/span/a"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//*[@id=\'main-wrapper\']/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div[1]/div/div[2]/div[3]"))
				.click();
		driver.close();
	}

}

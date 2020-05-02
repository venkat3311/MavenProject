package Maven.Selemium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\AU\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// htmlUnit driver is not available in selenium 3X version, to use this download
		// htmlUnitDriver jar

		// WebDriver driver = new HtmlUnitDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://ui.freecrm.com/");
		String beforeLogin = driver.getTitle();
		System.out.println("Before Login Title is  " + beforeLogin);
		driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys("venkatesh113@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Venkat@786");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		String afterLogin = driver.getTitle();
		System.out.println("After Login Title is  " + afterLogin);

		// driver.quit();
		System.out.println("End of script statement");

	}

}

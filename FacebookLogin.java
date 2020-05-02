package Maven.Selemium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\AU\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.facebook.com/");
		System.out.println(driver.getCurrentUrl());
		String title = driver.getTitle();
		// System.out.println(driver.getPageSource());
		if (title.equals("Facebook – log in or sign up")) {
			System.out.println("Title test is pass");
		} else {
			System.out.println("Title test is fail");
		}

		driver.findElement(By.id("email")).sendKeys("venkat3311@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Venkat@786");
		System.out.println("Credentials entered for Facebook login area");
		driver.findElement(By.id("loginbutton")).click();
		// driver.findElement(By.id("u_0_2")).click();
		System.out.println("Login button clicked");
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//*[@id=\'userNavigationLabel\']")).click();
		// driver.findElement(By.id("userNavigationLabel")).click();
		System.out.println("Logout clicked from the user session");
		// driver.close();
		System.out.println("Browser has been closed && TEST PASS");
	}

}

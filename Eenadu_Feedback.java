package Maven.Selemium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Eenadu_Feedback {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:/AU/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.eenadu.net/feedback/home");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebElement name = driver.findElement(By.xpath("//input[@id='txtname']"));
		name.sendKeys("Raju Mishra");
		WebElement mailId = driver.findElement(By.xpath("//input[@id='txtmailid']"));
		mailId.sendKeys("mishra@gmail.com");
		WebElement location = driver.findElement(By.xpath("//input[@id='txtloc']"));
		location.sendKeys("Bhopal");
		WebElement message = driver.findElement(By.xpath("//textarea[@id='txtmsg' and @class='stly4']"));
		message.sendKeys("We want to share with you latest updates on government schemes to be published in channel");
		WebElement submit = driver.findElement(By.xpath("//input[@value='Submit']"));
		submit.click();
		System.out.println("Feedback form submitted");
		Thread.sleep(3000);
		Alert alertpopup = driver.switchTo().alert(); // switch to alert method & Alert class object reference
		alertpopup.getText();
		System.out.println(alertpopup.getText());
		alertpopup.accept(); // confirms alert popuop to click on OK button
		// alertpopup.dismiss(); //clicks on cancel button from alert popup

		// driver.quit();

	}

}

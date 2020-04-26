package Maven.Selemium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Spicejet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\AU\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://spicejet.com");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		// driver.get("http://spicejet.com");
		driver.findElement(By.id("highlight-addons")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//*[@id=\'highlight-addons\']")).click();
		driver.findElement(By.xpath("//*[@id=\'header-vacations\']/a")).click();
		Thread.sleep(2000);
		// driver.findElement(By.id("header-vacations")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		driver.findElement(By.id("SpecialAssistanceToPLink")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\'header\']/div[1]/div[1]/a")).click();
		System.out.println("Home page click");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).click();
		System.out.println("Senior Citizen radiobutton");
		driver.findElement(By.partialLinkText("Assistance")).click();
		Thread.sleep(1000);
		driver.close();
		System.out.println("Test Completed");
	}

}

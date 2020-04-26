package Maven.Selemium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookRegister {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\AU\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='u_0_m']")).sendKeys("Venatesh");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='u_0_o']")).sendKeys("MURIKI");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='u_0_r']")).sendKeys("VENKAT@GMAIL.COM");
		Thread.sleep(2000);
		// driver.findElement(By.className("Re-enter email
		// address")).sendKeys("VENKAT@GMAILS.COM");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("VENKAT@GMAILS.COM");
		System.out.println("Reenter email field input done");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='u_0_w']")).sendKeys("PASSWORD1234");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='u_0_z']/span[1]/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='u_0_z']/span[2]/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='u_0_13']")).click();
		Thread.sleep(2000);
		System.out.println("Test Completed and browser being closed");
		driver.close();

	}

}

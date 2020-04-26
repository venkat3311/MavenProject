package Maven.Selemium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\AU\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.findElement(By.id("id")).sendKeys("Test input");
		driver.findElement(By.xpath("xpath details")).click();
		driver.findElement(By.name("name of attibute")).click();
		driver.findElement(By.tagName("name of tag")).click();
		driver.findElement(By.className("Element Class name")).click();
		driver.findElement(By.cssSelector("name of css")).sendKeys("input string");
		driver.findElement(By.linkText("name of hyperlink")).click();
		driver.findElement(By.partialLinkText("partial name of link")).click();

	}

}

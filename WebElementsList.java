package Maven.Selemium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsList {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:/AU/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().timeouts().implicitlyWait(105, TimeUnit.SECONDS);
		List<WebElement> products = driver.findElements(By.cssSelector("p[class='product-price']"));
		System.out.println("Number of product prices" + products.size()); // 30
		System.out.println("price " + products.get(0).getText()); // 120
		List<WebElement> buttons = driver.findElements(By.cssSelector("button[type='button']"));
		System.out.println("Number of buttons" + buttons.size() + "Buttons");
		// Label:"+buttons.get(1).getText());//Number of buttons35 Button Label ADD TO
		// CART
		WebElement link_topdeals = driver
				.findElement(By.xpath("//a[@class='cart-header-navlink' and @href='#/offers']"));
		System.out.println(" link label :" + link_topdeals.getText());
		link_topdeals.click();
		System.out.println("End of S");
	}

}
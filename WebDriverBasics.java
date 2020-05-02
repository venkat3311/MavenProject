package Maven.Selemium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverBasics {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\AU\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// Dynamic global wait for all elements
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);// handle page timeout loading
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://facebook.com");
		String title = driver.getTitle();
		System.out.println(title);
		driver.getPageSource();
		driver.getCurrentUrl();

		if (title.equals("Facebook – log in or sign up")) {
			System.out.println("Title test is pass");
		} else {
			System.out.println("Title test is fail");
		}

		// **XPATH PATTERNS to identify Web Elements: findelement method
		driver.findElement(By.xpath("")).click(); // Xpath-//inputtag[@attributename='value']
		driver.findElement(By.name("")).click();
		driver.findElement(By.className("")).clear();
		driver.findElement(By.id("")).click(); // input[@id='test_123'] //input[@id='test_456']
		driver.findElement(By.linkText("")).click(); // all links will be represented by <a> tag //a[]
		driver.findElement(By.partialLinkText("")).click();
		driver.findElement(By.cssSelector("#valueofelement")).click();// CSSSelector-inputtag[attributename,'value']
		driver.findElement(By.linkText("")).click();

		//// span[contains(text(),'Contacts')] //xpath with contains method
		// input[contains(@class,'Contacts')] //xpath with contains function

		// ***HANDLING of Dynamic element property using contains. ends-with &
		// starts-with functions
		// input[@id='test_a_test1234'] //input[@id='test_a4_test1234']
		// //input[@id='test_a4_test1234']
		driver.findElement(By.xpath("//input[contains(@id.'test_a']"));
		driver.findElement(By.xpath("//input[contains(test(), 'myaccount']")); // contains method
		driver.findElement(By.xpath("input[starts-with(@id,'test_']"));
		driver.findElement(By.xpath("input[end-with(@id,'_test1234']"));

		// ***HANDLING OF DRODPOWNS with Select class input element as parameter
		Select select = new Select(driver.findElement(By.id("Month")));

		select.selectByIndex(2);
		select.selectByValue("3");
		select.selectByVisibleText("Mar");

		// **XPATH PATTERNS to identify Array Web Elements: findelements method
		// get total count links and text of those links using html tag a property
		driver.get("https://www.ebay.com/"); // example website to get all links
		driver.manage().window().maximize();
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links are " + linkslist.size());
		for (int i = 0; i < linkslist.size(); i++) {
			String linkText = linkslist.get(i).getText();
			System.out.println(linkText);
		}
		System.out.println("End of script statement");

		// **Handling javascript alerts popup/windows
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi"); // example website
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@title='Sign in']")).click();
		Alert alertpopup = driver.switchTo().alert(); // switch to alert method & Alert class object reference
		alertpopup.getText();
		System.out.println(alertpopup.getText());
		alertpopup.accept(); // confirms alert popuop to click on OK button
		// alertpopup.dismiss(); //clicks on cancel button from alert popup
		Thread.sleep(1000); // STATIC wait code for 1sec

		// ***Handling WINDOWS like browse file upload option - sendkeys on WebElement
		driver.get("https://html.com/input-type-file/"); // example website
		driver.findElement(By.xpath("//input[@id='fileupload']"))
				.sendKeys("C:\\Users\\venkat\\Desktop\\BrowseFileApr.txt");
		System.out.println("End of script statement");

		// 1. Alerts java acript popup - Alert API method with Accept/Dismiss methods
		// 2. File upload popup - Browse button - (type=file, sendkeys with file path)
		// 3. Browser window/advertisement popup (Windowhandler API; getWindowHandles()]

		// HANDLING WINDOW POPUPS using WindowHandlers [Parent -child windows switching]
		driver.get("http://www.popuptest.com/goodpopups.html"); // example website window popups using windowhandles
		driver.findElement(By.xpath("//a[@class='blu']")).click(); // 2nd child window
		Set<String> handler = driver.getWindowHandles(); // set object values not stored index, so use iterator method;
		Iterator<String> it = handler.iterator();// import Iterator from java.util
		String parentWindowID = it.next();
		System.out.println("Parent Window Id is " + parentWindowID);
		String childWindowID = it.next();
		System.out.println("Child Window Id is " + childWindowID);
		driver.switchTo().window(childWindowID);
		String windowTitle = driver.getTitle();
		System.out.println("Browser Title is " + windowTitle);
		driver.close();
		driver.switchTo().window(parentWindowID);
		System.out.println("Parent window Title is " + driver.getTitle());
		Thread.sleep(3000);
		driver.quit();
		System.out.println("End of script statement");

		// ***HANDLING FRAME -elements(separate iframe) Index(0); Name=leftPannel;
		// venkatesh113@g Venat123
		driver.get("https://ui.freecrm.com"); // example website
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys("venkatesh113@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Venkat@786");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		// ***Right click on pannel to see "This Frame" on window and use frame handle
		// methods.
		driver.switchTo().frame(1); // input frame index number
		driver.switchTo().frame("firstframe"); // input frame name as string
		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		System.out.println("End of script statement");

		// *** MOUSE MOVEMENTS ON WEBPAGE-using Action class
		driver.get("https://spicejet.com"); // example website
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='highlight-addons']"))).build().perform();
		// mouse moves to the specific element and performs action to open menu
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Hot Meals')]")).click();
		System.out.println("End of script statement");

		// *** DRAG AND DROP from webpage elements [check page source for ifames]
		// Build and perform are mandatory when using Actions class
		driver.get("http://jqueryui.com/droppable"); // example website
		driver.manage().window().maximize();
		driver.switchTo().frame(0); // navigate/Switch to frame in webpage

		Actions action2 = new Actions(driver);
		action2.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']")))
				.moveToElement(driver.findElement(By.xpath("//div[@id='droppable']"))).release().build().perform();
		System.out.println("End of script statement");

		// **HANDLING EXTERNAL links & Browser navigations-Forward, Backward, refresh
		driver.get("https://www.ebay.com/"); // example website
		driver.navigate().to("https://facebook.com"); // used to launch external link
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.quit();

		System.out.println("End of script statement");

		// **HOW TO TAKE SCREENSHOT
		driver.get("https://www.ebay.com/"); // example website
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(src, new File("E:/AU/Screens/screenshot.png"));

		driver.quit();
		System.out.println("End of script statement");

		// **CONFIG PROPERTIES FILE FOR BETTER MAINTENANCE
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\SelIDE\\Selemium\\src\\main\\java\\Maven\\Selemium\\config.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("name"));
		String browserName = prop.getProperty("browser");
		System.out.println(prop.getProperty("url")); // null
		System.out.println(prop.getProperty("URL")); // value of URL will be printed
		System.out.println(prop.getProperty("age"));

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\AU\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "E:\\AU\\gechodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.IE.driver", "E:\\AU\\InternetExplorerdiver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(prop.getProperty("URL"));
		driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("password_xpath")).sendKeys("password");
		System.out.println("Credentials entered for Facebook login area");
		driver.findElement(By.xpath("submit_btn_xpath")).click();

		// ***HEADLESS(GHOST) BROWSER - HTMLUnitDriver in SELENIUM
		// htmlUnit driver is not available in selenium 3X version, to use this download
		// htmlUnitDriver jar to be added to buildpath
		// very fast execution without opening the brrowser
		// DOM structure is complex and sometimes not suitable for actions class

		System.setProperty("webdriver.chrome.driver", "E:\\AU\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		// WebDriver driver = new HtmlUnitDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://ui.freecrm.com/");
		String beforeLogin = driver.getTitle();
		System.out.println("Before Login Title is  " + beforeLogin);
		driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys("venkat@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("venkat1234");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		String afterLogin = driver.getTitle();
		System.out.println("After Login Title is  " + afterLogin);
		// driver.quit();

	}

	// ***Explicit Wait Method - element wise wait time to load.
	/*
	 * public static void clickOn(WebDriver driver, WebElement locator,int timeout){
	 * new WebDriver(driver,
	 * timeout).ignoring(StaleElementReferenceException.class).until(
	 * ExpectedConditions.elemenetToBeClicked(locator)).click(); }
	 */

}

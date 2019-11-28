package Login_v15.selenium_login_test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PositiveTest {
	
	private WebDriver driver;

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	private void setUp(@Optional("chrome") String browser) {
//		Create driver
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Do not know how to start " + browser + ", starting chrome instead");
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}

		// sleep for 3 seconds
		sleep(3000);

		// maximize browser window
		driver.manage().window().maximize();
	}
	
	@Test
	public void positiveLoginTest() {

		String url = "file:///C:/Users/yilis/Documents/TestChallenge/TestChallenge/Login_v15/Login_v15/index.html";
		driver.get(url);

		// sleep for 5 seconds
		sleep(5000);

		// enter username
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("");

		// enter password
		WebElement password = driver.findElement(By.name("pass"));
		password.sendKeys("");

		// click login button
		WebElement logInButton = driver.findElement(By.tagName("button"));
		logInButton.click();

		// sleep for 3 seconds
		sleep(3000);

		// Verify forgot password
		WebElement forgotPassword = driver.findElement(By.linkText("Forgot Password"));
		forgotPassword.click();

		// sleep for 3 seconds
		sleep(3000);

		// Verify remember me functionability
		WebElement rememberMe = driver.findElement(By.id("ckb1"));
		rememberMe.click();

		// sleep for 3 seconds
		sleep(3000);

		driver.quit();
	}

	
	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



package Login_v15.selenium_login_test;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class NegativeTest {
	
	@Test
	public void negativeLoginTest() {

		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// sleep for 3 seconds
		sleep(3000);

		// maximize browser window
		driver.manage().window().maximize();
				
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
		
		assertEquals("username is required", driver.findElement(By.cssSelector("div[class*='validate-input']")).getText());
		System.out.println("Username is required");

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

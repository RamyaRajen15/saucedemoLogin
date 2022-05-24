package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static WebDriver driver;
	public static String username="standard_user";
	public static String password="secret_sauce";


	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id='login_button_container']//form//div//input")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='login_button_container']//form//child::div[2]//input")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='login_button_container']//form//div[2]//following::input")).click();
		Thread.sleep(4000);
		driver.close();

	}

}

package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static WebDriver driver;
	public static String username="standard_user";
	public static String password="secret_sauce";
	public static String first_name="Ramya";
	public static String last_name="Rajendran";
	public static String zip_code="L5B0G9";


	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id='login_button_container']//form//div//input")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='login_button_container']//form//child::div[2]//input")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='login_button_container']//form//div[2]//following::input")).click();
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		driver.findElement(By.xpath("//*[@id='inventory_container']//button")).click();
		driver.findElement(By.xpath("//*[@class='primary_header']//div[3]//a")).click();
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		driver.findElement(By.xpath("//*[@class='cart_footer']//button[2]")).click();
		driver.findElement(By.xpath("//*[@class='checkout_info']//input")).sendKeys("first_name");
		driver.findElement(By.xpath("//*[@class='checkout_info']//div[2]//input")).sendKeys(last_name);
		driver.findElement(By.xpath("//*[@class='checkout_info']//div[3]//input")).sendKeys(zip_code);
		driver.findElement(By.xpath("//*[@class='checkout_buttons']//input")).click();
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		driver.findElement(By.xpath("//*[@class='cart_footer']//button[2]")).click();
		String expected_tittle="THANK YOU FOR YOUR ORDER";
		String actual_tittle = driver.findElement(By.xpath("//*[@id='contents_wrapper']//child::div//h2")).getText().trim();
		if(expected_tittle.equals(actual_tittle)) {
			System.out.println("Your Order has been Placed successfully!");
		}
		else {
			System.out.println("There are some issues with the order, please verify the details");
		}

		Thread.sleep(4000);
		driver.close();

	}

}

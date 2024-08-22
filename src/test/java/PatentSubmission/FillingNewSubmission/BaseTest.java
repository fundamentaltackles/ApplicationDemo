package PatentSubmission.FillingNewSubmission;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTest {

public WebDriver driver;
	

	@BeforeTest
	public WebDriver launchWebsite() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://auth.uspto.gov/app/uspto-gov_usptomyuspto_2/exk1d1jzh57lWcoK44h7/sso/saml?SAMLRequest=fVLLbtswEPwVgXeJkkxBCWEbcOMWdZ0mbuzWQC8GLVIWW%2FERLpXY%2FfoydB%2FuoTktd7gzixnsGJjqLZ0NvtMP4nEQ4JOj6jXQ%2BDFBg9PUMJBANVMCqG%2FoevbxlpZZTq0z3jSmRxeU1xkMQDgvjUbJYj5BO1YTxnPO6kqM%2BKiteTPiOdnzfXFVtfuKXBd1W1bXZHSFki%2FCQWBOUBAKdIBBLDR4pn2A8pKkOUmLalPmNC9oWX1FyTy4kZr5yOq8t0AxZsFqNoD1JjuYJ8ysxbFLQ7eLL3WKZVdicfxe8OLbj66q%2B21jloR0NQYw%2BMUpSma%2F3dwYDYMSbi3ck2zE54fbv%2FvU6WLbW7L88Lw9Pi6xMnzoRWY7G8UwnGuZsgYiejp84upuu9yiZPUr5zdSc6kPr0e8Pw8Bfb%2FZrNLV%2FXqDpuMXaRojc9M%2FwmN8CY%2FPl3AXBBfzlellc0reGaeY%2F%2F%2B%2BIisiInnaxlE6aLCika0UPOTT9%2Bb5xgnmxQR5NwiEp%2Bel%2F17c9Cc%3D&RelayState=https%3A%2F%2Fmy.uspto.gov%2Fhome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("input28")).sendKeys("ranvirmedicine@gmail.com");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("input65")).sendKeys("BHANGU1.Rab1");
		driver.findElement(By.cssSelector("input[value='Verify']")).click();
		driver.findElement(By.cssSelector("input[value='Send me an email']")).click();
		

		//Users//wonder//Downloads//ICE 1-100//ICE62.pdf
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-dashboard-1053450")));
	    
		return driver;
	}

	
	public static List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException 
	{
		//read json to string
		//String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json"));
		String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
		//string to HashMap 
		//get new dependencies jackson Databind
		
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String, String>> data =mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		//it will give list of {map,map}
		
		return data;
		
	}
}

package PatentSubmission.FillingNewSubmission;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class newApplication {
	
	@BeforeTest
	public void launchWebsite()
	{
		
	}
	
	@Test
	public void submitApplication() throws AWTException, InterruptedException, IOException
	{
		
		
		String submissionNumber= "ICE";
		String fileName="/Users/wonder/Downloads/data.xlsx";
		
		WebDriver driver = new ChromeDriver();
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
		Thread.sleep(2000);
		
		for(int i =304;i<305;i++)
		{
			driver.navigate().to("https://patentcenter.uspto.gov/");
			submissionNumber=submissionNumber+i;
			String title= getTitle(fileName,submissionNumber);
			//System.out.println(submissionNumber);
			
			if (title!=null)
			{
				//WebdriverWait wait = new WebdriverWait();
				driver.findElement(By.id("navbarDropdownMenuLink1")).click();
				driver.findElement(By.linkText("Utility-Provisional")).click();
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,500)");
				driver.findElement(By.cssSelector("a[class*='no-ads-btn']")).click();
			
				Select selectEntityStatus =new Select(driver.findElement(By.id("drDwn_entitystatus")));
				selectEntityStatus.selectByValue("3");
			
				js.executeScript("window.scrollBy(0,500)");
			
			
			
			
			
			//String fileName="/Users/wonder/Downloads/data.xlsx";
			
			//getColumnNum of price
					//int colNum= getColumnNum(fileName,"Title");//1
					//getRowNum of Apple
			//String title= getRowNum(fileName,submissionNumber);
					//update the value at given rowNum & colNum
					
			
			
			
				driver.findElement(By.id("TxtBox_invention")).sendKeys(title);
				driver.findElement(By.id("editbx_fname")).sendKeys("Ranvir");
				driver.findElement(By.id("editbx_mname")).sendKeys("Singh");
				driver.findElement(By.id("editbx_lname")).sendKeys("Bhangu");
			
				driver.findElement(By.linkText("Provide physical address")).click();
				js.executeScript("window.scrollBy(0,700)");
				
				driver.findElement(By.id("editbx_nameline1")).sendKeys("Ranvir Bhangu");
				Select selectCountry =new Select(driver.findElement(By.id("drDwn_country")));
				selectCountry.selectByValue("CA");
				//selectCountry.selectByVisibleText("CANADA "); too slow to select
				driver.findElement(By.id("editbx_st1")).sendKeys("8966 120 Street");
				driver.findElement(By.id("editbx_city")).sendKeys("Surrey");
				driver.findElement(By.id("drDwn_state")).sendKeys("BRITISH COLUMBIA ");
			//Select selectState =new Select(driver.findElement(By.id("drDwn_state")));
			//selectState.selectByVisibleText("BRITISH COLUMBIA ");
				driver.findElement(By.id("editbx_zip")).sendKeys("V3V 4B4");
				js.executeScript("window.scrollBy(0,300)");
				driver.findElement(By.id("editbx_email")).sendKeys("founder@nanobiotechnology.com");

				driver.findElement(By.cssSelector("button[class*='continue-btn']")).click();
				js.executeScript("window.scrollBy(0,300)");
			//driver.switchTo().alert().dismiss();
				WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			//WebElement ele= driver.findElement(By.cssSelector("input[id='customInput']"));
			//driver.findElement(with(By.tagName("label")).below(ele)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='custom-file']")));
		    //wait.until(ExpectedConditions.visibilityOf(null))
		    
			//Thread.sleep(3000);
				js.executeScript("window.scrollBy(0,700)");
				driver.findElement(By.cssSelector("div[class='custom-file']")).click();
		    //WebElement ele= driver.findElement(By.cssSelector("div[class='custom-file']"));
			//ele.sendKeys("//Users//wonder//Downloads//ICE 1-100//"+submissionNumber+".pdf");
			
			//driver.findElement(By.cssSelector("button[class*='continue-btn']")).click();
			
				selectFile(driver,submissionNumber);
			
		    //WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		     
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_toggle")));
		    
				driver.findElement(By.id("btn_toggle")).click();
				driver.findElement(By.cssSelector("button[value='Application Part']")).click();
				driver.findElement(By.cssSelector("button[value='Specification']")).click();
				driver.findElement(By.cssSelector("button[class*='continue-btn']")).click();
				
				driver.findElement(By.cssSelector("button[class='btn btn-outline-primary']")).click();
				
				WebElement titleElement = driver.findElement(By.xpath("//h6[text()='Title of invention']"));
				
				String titleText= driver.findElement(with(By.cssSelector("div p")).below(titleElement)).getText();
				
				Assert.assertEquals(titleText, title);
				js.executeScript("window.scrollBy(0,900)");
				driver.findElement(By.cssSelector("button[class*='submitbtn']")).click();
				
				Thread.sleep(2000);
				js.executeScript("window.scroll(0,100)");
				String text=driver.findElement(By.cssSelector("div[class*='alert-success']")).getText();
				if(text.contains("Your patent submission has been received by the USPTO"))
				{
					Assert.assertTrue(true);
				}
				else
				{
					System.out.println("Submission failed");
					break;
				}
				
		    //Assert.assertEquals(text, "Your patent submission has been received by the USPTO");
		    //TakesScreenshot ts = (TakesScreenshot)driver;
				
				File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File desFile= new File("/Users/wonder/Downloads/Screenshot "+submissionNumber+".png");
				FileUtils.copyFile(src,desFile);

		    
				driver.findElement(By.id("btn_save")).click();
				Thread.sleep(3000);
		    

		    
		   
				submissionNumber= "ICE";
		    //System.out.println(submissionNumber);
				
			}
			else
			{
				submissionNumber= "ICE";
			}
			
			
		
			
		}
	    
	    
	    
	}

	public static String getTitle(String fileName, String submissionNumber) throws IOException {
		// TODO Auto-generated method stub
		
		//int rowNum=0;
		String title = null;
		XSSFWorkbook wb= new XSSFWorkbook(fileName);
		int sheets=wb.getNumberOfSheets();
		for(int i=0; i<sheets;i++)
		{
			if (wb.getSheetName(i).equalsIgnoreCase("sheet1"))
			{
				XSSFSheet sheet= wb.getSheetAt(i);
				Iterator<Row> rows =sheet.iterator();
				while (rows.hasNext())
				{
					Row row=rows.next();
					Iterator<Cell> cells=row.cellIterator();
					while(cells.hasNext())
					{
						Cell c=cells.next();
						if(c.getStringCellValue().equalsIgnoreCase(submissionNumber))
						{
							if(cells.hasNext())
							{
								Cell cTitle = cells.next();
								if(cTitle.getStringCellValue()!=null)
								{
									title = cTitle.getStringCellValue();
									//System.out.println(title);
									break;
								}
								else
								{
									System.out.println("No Title");
								}
							}
							
							
							//rowNum=c.getRowIndex();
							//System.out.println(rowNum);
						}
					}
					
				}
				
			}
			
			
			
		}
		return title;
		
	}

	
	public void selectFile(WebDriver driver,String submissionNumber) throws AWTException
	{
		
		Robot robot= new Robot();
		StringSelection str = new StringSelection("//Users//wonder//Downloads//ICE 301-316//"+submissionNumber+".pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		driver.switchTo().window(driver.getWindowHandle());
		
		/*
		// use above instead of this for multiple uploads
		 * 
	    // CMD + TAB is needed to regain focus		    
	    robot.keyPress(KeyEvent.VK_META);		
	    robot.keyPress(KeyEvent.VK_TAB);		
	    robot.keyRelease(KeyEvent.VK_META);		
	    robot.keyRelease(KeyEvent.VK_TAB);		
	    robot.delay(1000);
			
			*/
	    // Open Goto window CMD+SHIFT+G		
	    robot.keyPress(KeyEvent.VK_META);		
	    robot.keyPress(KeyEvent.VK_SHIFT);		
	    robot.keyPress(KeyEvent.VK_G);		
	    robot.keyRelease(KeyEvent.VK_META);		
	    robot.keyRelease(KeyEvent.VK_SHIFT);		
	    robot.keyRelease(KeyEvent.VK_G);		
	    robot.delay(1000);
	 
	    // Paste the clip board value CMD+V		
	    robot.keyPress(KeyEvent.VK_META);		
	    robot.keyPress(KeyEvent.VK_V);		
	    robot.keyRelease(KeyEvent.VK_META);		
	    robot.keyRelease(KeyEvent.VK_V);		
	    robot.delay(1000);
	 
	    // Press Enter key to select file		
	    robot.keyPress(KeyEvent.VK_ENTER);		
	    robot.keyRelease(KeyEvent.VK_ENTER);		
	    robot.delay(1000);
	    
	 // Press Enter key to select file		
	    robot.keyPress(KeyEvent.VK_ENTER);		
	    robot.keyRelease(KeyEvent.VK_ENTER);		
	    robot.delay(1000);
	    
		/*
	    // Press Escape key to close the Goto window and Upload window		
	    robot.keyPress(KeyEvent.VK_ESCAPE);		
	    robot.keyRelease(KeyEvent.VK_ESCAPE);		
	    robot.delay(1000);
	    
	    /*
	 // Press Enter key to select file		
	    robot.keyPress(KeyEvent.VK_ENTER);		
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.delay(1000);
	    
	    // Press Escape key to close the Goto window
	    robot.keyPress(KeyEvent.VK_ESCAPE);		
	    robot.keyRelease(KeyEvent.VK_ESCAPE);		
	    robot.delay(1000);
	    */
	    
	    
	}
	

	public static void main(String[] args) {
		
		
		
		

	}

}

package PatentSubmission.FillingNewSubmission;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class newApplicationExcel {
	
	

	
	@Test
	public static void runApplication() throws InterruptedException, IOException, AWTException
	{

		
		String submissionName=null; 
		String copiedtitle=null;
		String title=null;
		
		String fileName="//Users//wonder//Downloads//Application.project//2k_applications//2k_applications.xlsx";

		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
	
		//options.setUnhandledPromptBehaviour(DISMISS());
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://auth.uspto.gov/app/uspto-gov_usptomyuspto_2/exk1d1jzh57lWcoK44h7/sso/saml?SAMLRequest=fVLLbtswEPwVgXeJkkxBCWEbcOMWdZ0mbuzWQC8GLVIWW%2FERLpXY%2FfoydB%2FuoTktd7gzixnsGJjqLZ0NvtMP4nEQ4JOj6jXQ%2BDFBg9PUMJBANVMCqG%2FoevbxlpZZTq0z3jSmRxeU1xkMQDgvjUbJYj5BO1YTxnPO6kqM%2BKiteTPiOdnzfXFVtfuKXBd1W1bXZHSFki%2FCQWBOUBAKdIBBLDR4pn2A8pKkOUmLalPmNC9oWX1FyTy4kZr5yOq8t0AxZsFqNoD1JjuYJ8ysxbFLQ7eLL3WKZVdicfxe8OLbj66q%2B21jloR0NQYw%2BMUpSma%2F3dwYDYMSbi3ck2zE54fbv%2FvU6WLbW7L88Lw9Pi6xMnzoRWY7G8UwnGuZsgYiejp84upuu9yiZPUr5zdSc6kPr0e8Pw8Bfb%2FZrNLV%2FXqDpuMXaRojc9M%2FwmN8CY%2FPl3AXBBfzlellc0reGaeY%2F%2F%2B%2BIisiInnaxlE6aLCika0UPOTT9%2Bb5xgnmxQR5NwiEp%2Bel%2F17c9Cc%3D&RelayState=https%3A%2F%2Fmy.uspto.gov%2Fhome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("input28")).sendKeys("ranvirmedicine@gmail.com");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("input65")).sendKeys("BHANGU1.Rab1");
		driver.findElement(By.cssSelector("input[value='Verify']")).click();
		driver.findElement(By.cssSelector("input[value='Send me an email']")).click();
		
		
		
		
		
		Thread.sleep(2000);
		
		for(int i= 320 ;i<498;i++)
		{
			
			driver.navigate().to("https://patentcenter.uspto.gov/");
			
			submissionName=getName(fileName,i);
			//System.out.println(submissionName);
			
			copiedtitle= getTitle(fileName,submissionName);
			title=copiedtitle.trim();
			//System.out.println(title);
			
			System.out.println(submissionName+" :"+title);
			
			
			if (title!=null)
			{
				WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(25));
				//System.out.println("submissionName: "+submissionName+" & title: "+title);
				
				driver.findElement(By.id("navbarDropdownMenuLink1")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Track One")));
				//driver.findElement(By.linkText("Utility-Provisional")).click();
				driver.findElement(By.linkText("Track One")).click();
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,500)");
				driver.findElement(By.cssSelector("a[class*='no-ads-btn']")).click();
			
				Select selectEntityStatus =new Select(driver.findElement(By.id("drDwn_entitystatus")));
				selectEntityStatus.selectByValue("3");
			
				js.executeScript("window.scrollBy(0,500)");
			
				
				Thread.sleep(1000);
				driver.findElement(By.id("TxtBox_invention")).sendKeys(title);
				Thread.sleep(1000);
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
			
				
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='custom-file']")));
		    
				js.executeScript("window.scrollBy(0,700)");
				driver.findElement(By.cssSelector("div[class='custom-file']")).click();
		    
			
				selectFile(driver,submissionName);
				String fileSelected=submissionName+".pdf";
				
				
				
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_toggle")));
		    
				driver.findElement(By.id("btn_toggle")).click();
				driver.findElement(By.cssSelector("button[value='Application Part']")).click();
				driver.findElement(By.cssSelector("button[value='Specification']")).click();
				driver.findElement(By.cssSelector("button[class*='continue-btn']")).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_proceed")));
				driver.findElement(By.id("btn_proceed")).click();
				
				js.executeScript("window.scrollBy(0,0)");
				driver.findElement(By.cssSelector("button[class='btn btn-outline-primary']")).click();
			    
				
				WebElement titleElement = driver.findElement(By.xpath("//h6[text()='Title of invention']"));
				
				String titleText= driver.findElement(with(By.cssSelector("div p")).below(titleElement)).getText();
				System.out.println(titleText);
				System.out.println(title);
				
				
				Assert.assertEquals(titleText, title);
				//Assert.assertTrue(driver.findElement(with(By.cssSelector("div p")).below(titleElement)).getText().equalsIgnoreCase(title));
				
					js.executeScript("window.scrollBy(0,900)");
					String selectedFile=driver.findElement(By.xpath("/html[1]/body[1]/pc-root[1]/div[1]/div[1]/pc-submissions[1]/div[1]/div[1]/section[2]/section[1]/div[1]/div[1]/div[1]/div[1]/pc-review[1]/div[1]/div[1]/div[1]/pc-review-upload-fees[1]/div[1]/pc-file-previewer[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/pc-upload-status[1]/div[1]/div[1]/span[2]\n")).getText();
					Assert.assertEquals(selectedFile, fileSelected);
					
					
					driver.findElement(By.cssSelector("button[class*='submitbtn']")).click();
					
				
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_proceed")));
					driver.findElement(By.id("btn_proceed")).click();
					
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mt-4")));
					
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
						
					Thread.sleep(2000);

					File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					File desFile= new File("//Users//wonder//Downloads//Application.project//2k_applications//png//SR//Screenshot "+submissionName+".png");
					FileUtils.copyFile(src,desFile);
					
			    
					driver.findElement(By.id("btn_save")).click();
					Thread.sleep(3000);
					System.out.println("for loop: "+i+" Excel Row: "+(i+1)+" is done");
					//System.out.println("Excel Row: "+i+1+" is done");

				
				
				
				
			}
			else
			{
				System.out.println("submissionName: "+submissionName+" & title is null ");
			}
			
			
		
			
		}
	    
	
	}
	


	private static String getName(String fileName,int j) throws IOException 
	{
		
		String Name = null;
		DataFormatter formatter = new DataFormatter();
		try (XSSFWorkbook wb = new XSSFWorkbook(fileName)) {
			int sheets=wb.getNumberOfSheets();
			for(int i=0; i<sheets;i++)
			{
				if (wb.getSheetName(i).equalsIgnoreCase("SR"))
				{
					XSSFSheet sheet= wb.getSheetAt(i);
					Iterator<Row> rows =sheet.iterator();
					Row row = rows.next();
					for(int k=0;k<j;k++)
					{
						 row=rows.next();
					}
							Iterator<Cell> cells=row.cellIterator();
						
							Cell c=cells.next();
							String strValue = formatter.formatCellValue(c);
							if(strValue!=null)
							{
								Name=strValue;
								
							}
							else
							{
								
								System.out.println("name is null field");
							}	
							
							//rowNum=c.getRowIndex();
							//colNum=c.getColumnIndex();
							//System.out.println("rowNum: "+rowNum+" and colNume: "+colNum);
								
				}
				
			}
		}
		//System.out.println(Name);
		return Name;

	}
	

	public static String getTitle(String fileName, String submissionName) throws IOException 
	{
		
		String title = null;
		DataFormatter formatter = new DataFormatter();
		try (XSSFWorkbook wb = new XSSFWorkbook(fileName)) {
			int sheets=wb.getNumberOfSheets();
			for(int i=0; i<sheets;i++)
			{
				if (wb.getSheetName(i).equalsIgnoreCase("SR"))
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
							

									
									String strValue = formatter.formatCellValue(c);

							//String cellname=c.getStringCellValue();
							if( strValue.equals(submissionName))
							{
								if(cells.hasNext())
								{
									Cell cTitle =  cells.next();
									
									//System.out.println( cTitle.getCellType());
									//String strCellValue = formatter.formatCellValue(cTitle);
									if(cTitle.getStringCellValue()!=null) 
									{

										title = cTitle.getStringCellValue();
										//DataFormatter formatter = new DataFormatter();
										//title=formatter.formatCellValue(cTitle);
										
										break;
									}
									
								}
								
							}
						}
						
					}
					
				}
				
				
				
			}
		}
		//System.out.println(title);
		return title;
		
	}

	
	public static void selectFile(WebDriver driver,String submissionName) throws AWTException
	{
		
		Robot robot= new Robot(); 
		StringSelection str = new StringSelection("//Users//wonder//Downloads//Application.project//2k_applications//2k_data//SR//"+submissionName+".pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		driver.switchTo().window(driver.getWindowHandle());
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
	    robot.delay(3000);
	 
	    // Press Enter key to select file		
	    robot.keyPress(KeyEvent.VK_ENTER);		
	    robot.keyRelease(KeyEvent.VK_ENTER);		
	    robot.delay(3000);
	    
	 // Press Enter key to select file		
	    robot.keyPress(KeyEvent.VK_ENTER);		
	    robot.keyRelease(KeyEvent.VK_ENTER);		
	    robot.delay(1000);
	 
	    
		
	    
	}
	
		
}



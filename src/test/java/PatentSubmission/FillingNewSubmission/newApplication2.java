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
import java.util.*;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
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

import com.sun.tools.javac.code.Attribute.Array;

public class newApplication2 {
	
	

	

	private static String getName(String fileName,int j) throws IOException 
	{
		int rowNum=0;
		int colNum=0;
		String Name = null;
		XSSFWorkbook wb= new XSSFWorkbook(fileName);
		int sheets=wb.getNumberOfSheets();
		for(int i=0; i<sheets;i++)
		{
			if (wb.getSheetName(i).equalsIgnoreCase("sheet1"))
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
						if(c.getStringCellValue()!=null)
						{
							Name=c.getStringCellValue();
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
		//System.out.println(Name);
		return Name;

	}
	
	

	public static String getTitle(String fileName, String submissionName) throws IOException 
	{
		
		int rowNum=0;
		int colNum=0;

		String title = null;
		String title1= null;
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
						if(c.getStringCellValue().equalsIgnoreCase(submissionName))
						{
							if(cells.hasNext())
							{
								Cell cTitle =  cells.next();
								
								//System.out.println( cTitle.getCellType());
								if(cTitle.getCellType() == CellType.STRING) 
								{

									title = cTitle.getStringCellValue();
									title1=title.toString().trim();
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
		//System.out.println(title);
		return title1;
		
	}

	
	public static void selectFile(WebDriver driver,String submissionName) throws AWTException
	{
		
		Robot robot= new Robot(); 
		StringSelection str = new StringSelection("//Users//wonder//Downloads//Application.project//SC//SC-data//"+submissionName+".pdf");
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
	    robot.delay(4000);
	    
	 // Press Enter key to select file		
	    robot.keyPress(KeyEvent.VK_ENTER);		
	    robot.keyRelease(KeyEvent.VK_ENTER);		
	    robot.delay(1000);
	 
	    
		
	    
	}
	
	@Test
	public static void runApplication() throws InterruptedException, IOException, AWTException
	{

		
		String submissionName=null; 
		String title=null;
		String fileName="//Users//wonder//Downloads//Application.project//SC//sc.xlsx";
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
	
		//options.setUnhandledPromptBehaviour(DISMISS());
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		
		
		for(int i =5;i<10;i++)
		{
			
			submissionName=getName(fileName,i);
			//System.out.println(submissionName);
			
			title= getTitle(fileName,submissionName);
			//System.out.println(title);
			
			System.out.println(title);
			String actual= title.trim();
			System.out.println(actual);
			Assert.assertEquals(actual, title);
			
			//Assert.assertTrue(driver.findElement(with(By.cssSelector("div p")).below(titleElement)).getText().equalsIgnoreCase(title));
			
			
			
				System.out.println("for loop: "+i+" Excel Row: "+(i+1)+" is done");
				//System.out.println("Excel Row: "+i+1+" is done");

			
				
			
			
			
		
			
		}
	    
	
	}
	
	
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		// TODO Auto-generated method stub

	}
		
}



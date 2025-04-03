package testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class LoginTest {
	WebDriver driver;
	Properties prop;
	@BeforeMethod
	public void setup() throws IOException {
		prop = new Properties();
		String path = System.getProperty("user.dir") + "//src//test//resources//configFiles//config.properties";
		FileInputStream fin = new FileInputStream(path);
		prop.load(fin);
		
		String strBrowser = prop.getProperty("browser");
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (strBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test (dataProvider = "loginData")
  public void loginPageTest(String strUser, String strPwd) {
	  driver.get(prop.getProperty("url"));
	  driver.findElement(By.id (readObjPath("loginUser"))).sendKeys(strUser);
	  driver.findElement(By.id (readObjPath("loginPwd"))).sendKeys(strPwd);
	  driver.findElement(By.className(readObjPath("loginBtn"))).click();
	  boolean isValidUser = driver.findElement(By.cssSelector(readObjPath("successMsg"))).isDisplayed();
	  Assert.assertTrue(isValidUser);
//	  System.out.println(isValidUser);
	  
  }
	
	@DataProvider(name="loginData")
	public Object[][] getData() throws CsvValidationException, IOException {
	
		String path = System.getProperty("user.dir") + "//src//test//resources//testData//loginData.csv";
		CSVReader reader = new CSVReader(new FileReader(path));
		String cols[];
		ArrayList<Object> dataList = new ArrayList<Object>();
		while((cols = reader.readNext()) !=null) {
			Object record[] = { cols[0], cols[1] };
			dataList.add(record);
		}
		reader.close();
		return dataList.toArray(new Object[dataList.size()][]);
				
	}
	
	// To use excel as ObjectRepository
	public String readObjPath(String objName) {
		String objPath = "";
		String path = System.getProperty("user.dir") + "//src//test//resources//testData//loginRepo.xlsx";
		//HSSF ... --> .xls
		//XSSF ... --> .xlsx
		FileInputStream fin;
		XSSFWorkbook workbook = null;
		
		try {
			fin = new FileInputStream(path);
			workbook= new XSSFWorkbook(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet loginSheet = workbook.getSheet("loginPage");
		int numRows = loginSheet.getLastRowNum();
		for(int i=1; i<=numRows; i++) {
		   XSSFRow row = loginSheet.getRow(i);
		   if(row.getCell(0).getStringCellValue().equalsIgnoreCase(objName)) {
			 objPath = row.getCell(1).getStringCellValue();
		   }
	    }
		return objPath;
		
		
	}
	
	
	
	
}

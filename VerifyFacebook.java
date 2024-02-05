package org.Guvitaskday23;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VerifyFacebook {
public static void main(String[] args) throws IOException {
//	in this test case we have to pass datas so here we get the datas from the EXCEL sheet
	XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\HP\\Eclipse workspace new\\SeleniumPractice\\Files\\Fileone.xlsx");
	XSSFSheet sheet = book.getSheet("Sheet1");
	XSSFRow row1 = sheet.getRow(0);
	
// here we have to send the String values so we change cell value to string using toString method;
// first we fetch the first row data's
	String Fname = row1.getCell(0).toString();		System.out.println(Fname);
	String Lname = row1.getCell(1).toString();		System.out.println(Lname);
// next we have to fetch the second row data's
	XSSFRow row2 = sheet.getRow(1);
	String Email = row2.getCell(0).toString();		System.out.println(Email);
	String Pword = row2.getCell(1).toString();		System.out.println(Pword);
	WebDriverManager.chromedriver().setup();
// to launching the browser here we have create instance of webdriver interface
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
//	below codes we were used the datas from EXCEL Sheet 
	driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(Fname);
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Lname);
	driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(Email);
	driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(Pword);
	driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(Email);
// here we can see the web element tag name comes with select tag name at the stage we have to decide declare select class 
	WebElement Bdate = driver.findElement(By.xpath("//select[@name='birthday_day']"));
	Select select1 = new Select(Bdate);
// here we select the option by value using selectByValue
	select1.selectByValue("11");
	
	WebElement Bmonth = driver.findElement(By.xpath("//select[@name='birthday_month']"));
	Select select2 = new Select(Bmonth);
// here we select the option by INDEX using selectByIndex
	select2.selectByIndex(4);
	
	WebElement Byear = driver.findElement(By.xpath("//select[@name='birthday_year']"));
	Select select3 = new Select(Byear);
// here we select the option by value using selectByValue	
	select3.selectByValue("1985");
	
	driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
	driver.findElement(By.xpath("//button[@name='websubmit']")).click();

	
	}
}

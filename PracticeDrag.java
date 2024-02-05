package org.Guvitaskday23;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.http2.frame.Frame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PracticeDrag {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("https://jqueryui.com/");
		driver.findElement(By.xpath("//a[@href='https://jqueryui.com/droppable/']")).click();
		
//	    (drag and drop) elements was placed inside of the iframe, so we have to switch in to the i frame
		WebElement frame = driver.findElement(By.xpath("//iframe[@src='/resources/demos/droppable/default.html']"));
		driver.switchTo().frame(frame);
//		here we have to make mouse actions so we declare the action class to perform that;
		Actions act = new Actions(driver);
		WebElement drag = driver.findElement(By.xpath("//div[@class='ui-widget-content ui-draggable ui-draggable-handle']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
//      here drag and drop actions are performed by using drag and drop method
		act.dragAndDrop(drag, drop).perform();
	
// 		here we can try drag and drop using x and y axis on the web page 
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='Draggable']")).click();
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='/resources/demos/draggable/default.html']"));
		driver.switchTo().frame(frame2);
		Actions act2= new Actions(driver);
		WebElement drag2 = driver.findElement(By.id("draggable"));
		act2.dragAndDropBy(drag2, 320, 38).perform();
//		here we practice the scroll down the webpage using moveToElement method		
		driver.switchTo().parentFrame();
		WebElement scrollele = driver.findElement(By.xpath("//a[text()='Position']"));
		act2.moveToElement(scrollele).perform();
		
		
	}

}

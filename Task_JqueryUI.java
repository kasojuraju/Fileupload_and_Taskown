import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;


public class Task_JqueryUI {
	static WebDriver d;
	public static Logger logger=Logger.getLogger(Task_JqueryUI.class);
	@Test
	public static void m() {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\Selenium\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("https://jqueryui.com/");
		logger.info("webpage opened successfully");
		
	}

	private DateFormat df;
	@Test(priority=1)
	public void selectmenu() throws IOException {
		d.findElement(By.xpath("//div[@id='sidebar']/aside[2]/ul/li[10]/a")).click();
		d.switchTo().frame(d.findElement(By.xpath("//iframe[@src='/resources/demos/selectmenu/default.html']")));
		d.findElement(By.id("speed-button")).click();
		d.findElement(By.id("ui-id-2")).click();
		File sc1 = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		Date d1 = new Date();
		DateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS");
		System.out.println(df.format(d1));
		FileUtils.copyFile(sc1,	new File("C:\\Nag\\New folder\\Workso2\\Sample_Task_SC\\Sample_" + df.format(d1) + ".png"));
		d.findElement(By.id("files-button")).click();
		d.findElement(By.id("ui-id-7")).click();
		d.findElement(By.id("number-button")).click();
		d.findElement(By.id("ui-id-12")).click();
		d.findElement(By.id("salutation-button")).click();
		d.findElement(By.id("ui-id-30")).click();
		d.switchTo().defaultContent();
		d.findElement(By.xpath("//form[@class='searchform']/label/input")).sendKeys("Selenium");
		d.findElement(By.xpath("//form[@class='searchform']/button")).click();
		d.findElement(By.xpath("//div[@id='container']/div/h2/a")).click();
		JavascriptExecutor j1 = (JavascriptExecutor) d;
		j1.executeScript("window.scrollBy(0,486)", "");
		d.findElement(By.xpath("//div[@id='sidebar']/aside[2]/ul/li[1]/a")).click();
		d.switchTo().frame(d.findElement(By.xpath("//iframe[@class='demo-frame']")));
		d.findElement(By.xpath("//div[@id='accordion']/h3[2]")).click();
		d.findElement(By.xpath("//div[@id='accordion']/h3[3]")).click();
		d.switchTo().defaultContent();
	}
	@Test(priority=2)
	public void m1() throws Exception {		
		
		d.findElement(By.xpath("//div[@id='container']/div/h2/a")).click();
		JavascriptExecutor j2 = (JavascriptExecutor) d;
		j2.executeScript("window.scrollBy(0,612)", "");
		d.findElement(By.xpath("//div[@id='sidebar']/aside[2]/ul/li[11]/a")).click();
		d.switchTo().frame(d.findElement(By.xpath("//iframe[@src='/resources/demos/slider/default.html']")));
		WebElement slide = d.findElement(By.xpath("//div[@id='slider']/span"));
		Action m = new Actions(d).dragAndDropBy(slide, 500, 0).build();
		m.perform();
		Date d2 = new Date();
		File Sc2 = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Sc2,
				new File("C:\\\\Nag\\\\New folder\\\\Workso2\\\\Sample_Task_SC\\\\Sample_" + df.format(d2) + ".png"));
	}

	@Test(priority=3)
	public void draganddrop() throws Exception {
		d.findElement(By.xpath("//a[@href='https://jqueryui.com/droppable/']")).click();
		d.switchTo().frame(d.findElement(By.className("demo-frame")));
		WebElement dragfrom = d.findElement(By.cssSelector("div[id=draggable]"));
		WebElement dragto = d.findElement(By.cssSelector("div[id=droppable]"));
		Actions drag = new Actions(d);
		drag.dragAndDrop(dragfrom, dragto).perform();
		d.switchTo().defaultContent();
		Thread.sleep(2000);
	}

	@Test(priority=4)
	public void resizeelement() throws Exception {
		d.findElement(By.xpath("//a[@href='https://jqueryui.com/resizable/']")).click();
		d.switchTo().frame(d.findElement(By.className("demo-frame")));
		WebElement resize = d.findElement(By.xpath("//*[@id='resizable']/div[3]"));

		new Actions(d).clickAndHold(resize).moveByOffset(50, 50).release().perform();
		Thread.sleep(2000);
		new Actions(d).clickAndHold(resize).moveByOffset(100, 100).release().perform();

		d.switchTo().defaultContent();
		Thread.sleep(2000);

	}

	@AfterClass
	public static void m3() throws Exception {
		d.close();
	}

}

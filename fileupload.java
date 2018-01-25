import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class fileupload {

	WebDriver d;

	@Test
	public void uploaading() throws AWTException, InterruptedException {
		d = new ChromeDriver();
		d.get("https://encodable.com/uploaddemo/");
		d.findElement(By.cssSelector("input[name=uploadname1]")).click();
		Thread.sleep(3000);
		fileupld("C:\\Nag\\Programs_Rk\\Screenshort_frame.txt");
		Thread.sleep(3000);
	}

	public void fileupld(String Location) throws AWTException {
		try {
			clipboard(Location);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void clipboard(String data) {
		StringSelection ss = new StringSelection(data);
		Toolkit.getDefaultToolkit().getSystemClipboard().getContents(ss);
	}

	@AfterClass
	public void close() {
		d.close();
	}
}

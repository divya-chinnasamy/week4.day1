package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Html {

	public static void main(String[] args) {
		// 1. Launch the URL https://html.com/tags/table/
		WebDriverManager.chromedriver().setup();
		// Step 2: Launch the chromebrowser
		ChromeDriver obj = new ChromeDriver();
		// Step 3: Load the URL https://en-gb.facebook.com/
		obj.get("https://html.com/tags/table/");	
		// Step 4: Maximise the window
		obj.manage().window().maximize();
		System.out.println(obj.getTitle());
		obj.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Get the count of number of rows
		List<WebElement> rows = obj.findElements(By.xpath("//table[@class='attributes-list']//tr"));
		int rowSize = rows.size(); 
		System.out.println("Total number of rows in the table: " + rowSize);
		
		//3. Get the count of number of columns
		List<WebElement> cols = obj.findElements(By.xpath("//table[@class='attributes-list']//tr//th"));
		System.out.println("Total number of coloumns in the table: " +cols.size());
	}

}

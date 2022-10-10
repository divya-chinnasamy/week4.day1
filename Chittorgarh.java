package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		// Step 2: Launch the chromebrowser
		ChromeDriver obj = new ChromeDriver();
		// Step 3: Load the URL https://en-gb.facebook.com/
		obj.get("https://www.chittorgarh.com/");	
		// Step 4: Maximise the window
		obj.manage().window().maximize();
		System.out.println(obj.getTitle());
		obj.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(3000);
		//Click on stock market
		obj.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();
		//Click on NSE bulk Deals
		obj.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		
		//get all security names
		List<WebElement> secNames= obj.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr//td[3]"));
		List<String>list = new ArrayList<String>();
		int totSecNames = secNames.size();
		System.out.println("Total number of Security Name records in the table: " + totSecNames);
		
		//Adding the security names to a list
		for (WebElement eachSecName : secNames) {
			String names = eachSecName.getText();
		//	System.out.println(names);	
			list.add(names);		
		}
		
		//Printing Unique set of Security names
		Set<String> unique= new TreeSet<String>(list);
		System.out.println("Total number of Unique Security names in the unique set: " + unique.size());
		System.out.println(unique);
	}

}

//Chittorgarh:
//	// 1. Launch the URL https://www.chittorgarh.com/
//	//2. Click on stock market
//	//3. Click on NSE bulk Deals
//	//4. Get all the Security names
//	//5. Ensure whether there are duplicate Security names

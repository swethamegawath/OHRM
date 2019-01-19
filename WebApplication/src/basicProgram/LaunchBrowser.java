package basicProgram;


import org.openqa.selenium.chrome.ChromeDriver;


public class LaunchBrowser {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver.exe");
		System.out.println(System.getProperty("user.dir"));
		
		//this two statements works on Selenium server standalone 2.53.1
		ChromeDriver driver = new ChromeDriver();
		System.out.println("Launch the browser");
		
		
		driver.get("http://newtours.demoaut.com/"); 
		System.out.println("Navigated to new tours home page");
		
		 String actual_title=driver.getTitle();
		 System.out.println(actual_title);
		 
		 String expected_title="Mercury Tours";
		 System.out.println(expected_title);
		 
		 if(actual_title.contains(expected_title))
		 {
			 System.out.println("Title Matched - PASS");
		 }
		 else
		 {
			 System.out.println("title not matched - FAIL");
		 }
		 
		 String actual_url=driver.getCurrentUrl();
		 System.out.println(actual_url);
		 
		 String expected_url = "newtours";
		 if(actual_url.contains(expected_url))
		 {
			 System.out.println("actual url contains the expected url");
		 }
		 else
		 {
			 System.out.println("actual url doesnt contain any expected url");
		 }
		 
		
	}

}

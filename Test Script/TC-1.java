package pharmacy;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddUser {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\libs\\selenium-jars\\chromedriver-win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://edgebook.wuaze.com/admin.php");
        
        Thread.sleep(1000);

        // Log in as Admin
        driver.findElement(By.name("uname")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.name("submit")).click();

        Thread.sleep(1000);

        // Navigate to Add User
        driver.findElement(By.linkText("Add User")).click();

        // Fill User Details
        driver.findElement(By.name("name")).sendKeys("John Doe");
        driver.findElement(By.name("role")).sendKeys("Pharmacist");
        driver.findElement(By.name("username")).sendKeys("john.doe");
        driver.findElement(By.name("submit")).click();

        // Verify success message
        String message = driver.findElement(By.id("successMsg")).getText();
        if (message.contains("User added successfully")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        
        driver.quit();
    }
}

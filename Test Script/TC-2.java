package pharmacy;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UpdateUser {
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

        // Navigate to User List
        driver.findElement(By.linkText("User List")).click();

        // Select a user to update
        driver.findElement(By.xpath("//td[text()='John Doe']/following-sibling::td/a[text()='Edit']")).click();

        // Update details
        driver.findElement(By.name("role")).clear();
        driver.findElement(By.name("role")).sendKeys("Manager");
        driver.findElement(By.name("submit")).click();

        // Verify success message
        String message = driver.findElement(By.id("successMsg")).getText();
        if (message.contains("User updated successfully")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        
        driver.quit();
    }
}

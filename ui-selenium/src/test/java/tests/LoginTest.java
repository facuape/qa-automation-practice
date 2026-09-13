package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

  @Test
void loginConCredencialesValidas() throws InterruptedException {
    driver.get("https://www.saucedemo.com/");
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();

    Thread.sleep(3000); // pausa de 3 segundos, solo para poder ver el resultado

    String urlActual = driver.getCurrentUrl();
    assertTrue(urlActual.contains("inventory.html"), "No se redirigio a la pagina de productos");
}
    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
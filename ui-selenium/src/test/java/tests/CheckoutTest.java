package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;
import pages.CheckoutPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @Test
    void compraCompleta() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.abrir();
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.agregarMochilaAlCarrito();
        inventoryPage.irAlCarrito();

        cartPage.irACheckout();

        checkoutPage.completarDatos("Facundo", "Pecechea", "1234");
        checkoutPage.finalizarCompra();

String mensaje = driver.findElement(By.className("complete-header")).getText();
        assertTrue(mensaje.toLowerCase().contains("thank you"), "No se completo la compra correctamente");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
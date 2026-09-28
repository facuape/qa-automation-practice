package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.net.URL;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiDemosTest {

    AndroidDriver driver;

    @BeforeEach
    void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setAppPackage("io.appium.android.apis")
                .setAppActivity(".ApiDemos")
                .setAutomationName("UiAutomator2")
                .setPlatformName("Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void seVeLaCategoriaApp() {
        String texto = driver.findElement(By.xpath("//*[@text='App']")).getText();
        assertTrue(texto.equals("App"), "No se encontro la categoria App en la lista");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
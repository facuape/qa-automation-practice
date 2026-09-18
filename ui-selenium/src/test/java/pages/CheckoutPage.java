package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private By campoNombre = By.id("first-name");
    private By campoApellido = By.id("last-name");
    private By campoCodigoPostal = By.id("postal-code");
    private By botonContinuar = By.id("continue");
    private By botonFinalizar = By.id("finish");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void completarDatos(String nombre, String apellido, String codigoPostal) throws InterruptedException {
        driver.findElement(campoNombre).sendKeys(nombre);
        driver.findElement(campoApellido).sendKeys(apellido);
        driver.findElement(campoCodigoPostal).sendKeys(codigoPostal);
        driver.findElement(botonContinuar).click();
        Thread.sleep(1500);
    }

    public void finalizarCompra() throws InterruptedException {
        driver.findElement(botonFinalizar).click();
        Thread.sleep(1500);
    }
}
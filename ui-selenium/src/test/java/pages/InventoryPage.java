package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    private By botonAgregarMochila = By.id("add-to-cart-sauce-labs-backpack");
    private By iconoCarrito = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void agregarMochilaAlCarrito() {
        driver.findElement(botonAgregarMochila).click();
    }

    public void irAlCarrito() throws InterruptedException {
        driver.findElement(iconoCarrito).click();
        Thread.sleep(1500);
    }
}
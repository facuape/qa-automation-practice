package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By botonCheckout = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void irACheckout() throws InterruptedException {
        driver.findElement(botonCheckout).click();
        Thread.sleep(1500);
    }
}
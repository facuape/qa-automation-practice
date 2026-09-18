package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By campoUsuario = By.id("user-name");
    private By campoPassword = By.id("password");
    private By botonLogin = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrir() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String usuario, String password) {
        driver.findElement(campoUsuario).sendKeys(usuario);
        driver.findElement(campoPassword).sendKeys(password);
        driver.findElement(botonLogin).click();
    }
}
package com.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By usernameInput = By.id("user");
    private final By passwordInput = By.id("pass");
    private final By loginButton = By.id("loginBtn");

    public LoginPage(WebDriver driver) {
        super(driver);
}
    public void navigateTo(String url) {
        driver.get(url);
    }

    public void login(String username, String password) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}

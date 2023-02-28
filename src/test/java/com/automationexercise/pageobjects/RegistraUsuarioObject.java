package com.automationexercise.pageobjects;

import com.automationexercise.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistraUsuarioObject {
    private final WebDriver driver;
    private final WaitElement waitElement;

    public RegistraUsuarioObject(WebDriver _driver) {
        driver = _driver;
        waitElement = new WaitElement(_driver);
    }

    public WebElement validadoTelaDeIndexLabel() {
        return waitElement.visibilityOf(By.cssSelector("#slider-carousel > div > div:nth-child(1) > div:nth-child(1) > h1"));
    }

    public WebElement acessaTelaDeLoginButton() {
        return waitElement.toBeClickable(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a"));
    }

    public WebElement visivelDeNewUserSignUpLabel() {
        return waitElement.visibilityOf(By.cssSelector("#form > div > div > div:nth-child(3) > div > h2"));
    }

    public WebElement nomeUmNovoUsuarioTextField() {
        return waitElement.toBeClickable(By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)"));
    }

    public WebElement emailDoUsuarioTextField() {
        return waitElement.toBeClickable(By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)"));
    }

    public WebElement signupButton() {
        return waitElement.toBeClickable(By.cssSelector("#form > div > div > div:nth-child(3) > div > form > button"));
    }

    public WebElement visivelDeEnterAccountInformationLabel() {
        return waitElement.visibilityOf(By.cssSelector("#form > div > div > div > div > h2 > b"));
    }
}
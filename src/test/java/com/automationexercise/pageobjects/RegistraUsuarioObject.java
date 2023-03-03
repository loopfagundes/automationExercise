package com.automationexercise.pageobjects;

import com.automationexercise.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public WebElement generoDoUsuarioCheckBox() {
        return waitElement.toBeClickable(By.id("id_gender1"));
    }

    public WebElement senhaDaContaDoUsuarioTextField() {
        return waitElement.toBeClickable(By.id("password"));
    }

    public Select diaDeNascimentoDoUsuarioComboBox() {
        return new Select(driver.findElement(By.id("days")));
    }

    public Select mesDeNascimentoDoUsuarioComboBox() {
        return new Select(driver.findElement(By.id("months")));
    }

    public Select anoDeNascimentoDoUsuarioComboBox() {
        return new Select(driver.findElement(By.id("years")));
    }

    public WebElement signUpForOurNewSletterCheckBox() {
        return waitElement.toBeClickable(By.id("newsletter"));
    }

    public WebElement receiveSpecialOffersFormOurPatnersCheckBox() {
        return waitElement.toBeClickable(By.id("optin"));
    }

    public WebElement visivelDeInformarEnderecoLabel() {
        return waitElement.visibilityOf(By.cssSelector("#form > div > div > div > div.login-form > form > h2 > b"));
    }

    public WebElement primeiroNomeDoUsuarioTextField() {
        return waitElement.toBeClickable(By.id("first_name"));
    }

    public WebElement sobreNomeDoUsuarioTextField() {
        return waitElement.toBeClickable(By.id("last_name"));
    }

    public WebElement empresaDoUsuarioTextField() {
        return waitElement.toBeClickable(By.id("company"));
    }

    public WebElement enderecoDoUsuarioTextField() {
        return waitElement.toBeClickable(By.id("address1"));
    }

    public Select paisDoUsuarioComboBox() {
        return new Select(driver.findElement(By.id("country")));
    }

    public WebElement estadoDoUsuarioTextField() {
        return waitElement.toBeClickable(By.id("state"));
    }

    public WebElement cidadeDoUsuarioTextField() {
        return waitElement.toBeClickable(By.id("city"));
    }

    public WebElement cepDoEnderecoDoUsuarioTextField() {
        return waitElement.toBeClickable(By.id("zipcode"));
    }

    public WebElement numeroDeContatoDoUsuarioTextField() {
        return waitElement.toBeClickable(By.id("mobile_number"));
    }

    public WebElement criaContaDoUsuarioButton() {
        return waitElement.toBeClickable(By.cssSelector("#form > div > div > div > div.login-form > form > button"));
    }

    public WebElement visivelDeContaCriaLabel() {
        return waitElement.visibilityOf(By.cssSelector("#form > div > div > div > h2 > b"));
    }

    public WebElement continuaButton() {
        return waitElement.toBeClickable(By.cssSelector("#form > div > div > div > div > a"));
    }

//    public WebElement visivelUsuarioEstaLogadoLabel() {
//        return waitElement.visibilityOf(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a"));
//    }

//    public WebElement fechaAdsDoAnuncioButton() {
//        return waitElement.toBeClickable(By.cssSelector("#dismiss-button > div > svg > path:nth-child(1)"));
//    }
}
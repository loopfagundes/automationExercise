package com.automationexercise.steps;

import com.automationexercise.pageobjects.RegistraUsuarioObject;
import com.automationexercise.utils.JsExcutor;
import com.automationexercise.utils.Screenshot;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistraUsuarioStep {
    private final WebDriver driver;
    private final RegistraUsuarioObject registraUsuarioObject;
    private final Faker faker = new Faker();

    public RegistraUsuarioStep(WebDriver _driver) {
        driver = _driver;
        registraUsuarioObject = new RegistraUsuarioObject(_driver);
    }

    public RegistraUsuarioStep efeturaLogin() {
        telaDeIndex();
        telaDeLoginDoUsuario();
        criaUmaNovaContaDoUsuario();
        return this;
    }

    private RegistraUsuarioStep telaDeIndex() {
        ExtentTestManager.getTest().log(Status.INFO, "Acessa na tela de login.");
        if (registraUsuarioObject.validadoTelaDeIndexLabel().isDisplayed()) {
            ExtentTestManager.getTest().log(Status.PASS, "A pagina esta tela de login.");
        } else {
            JsExcutor.highlight(driver, registraUsuarioObject.validadoTelaDeIndexLabel());
            ExtentTestManager.getTest().log(Status.FAIL, "A pagina não esta correta.", Screenshot.capture());
        }
        Assert.assertEquals(registraUsuarioObject.validadoTelaDeIndexLabel().getText(), "AutomationExercise");
        registraUsuarioObject.acessaTelaDeLoginButton().click();
        Assert.assertEquals(registraUsuarioObject.visivelDeNewUserSignUpLabel().getText(), "New User Signup!");
        return this;
    }

    private RegistraUsuarioStep telaDeLoginDoUsuario() {
        ExtentTestManager.getTest().log(Status.INFO, "Acessa na tela de criar nova uma conta.");
        if (registraUsuarioObject.visivelDeNewUserSignUpLabel().isDisplayed()) {
            ExtentTestManager.getTest().log(Status.PASS, "A pagina de meu login esta correta.");
        } else {
            JsExcutor.highlight(driver, registraUsuarioObject.visivelDeNewUserSignUpLabel());
            ExtentTestManager.getTest().log(Status.FAIL, "A pagina de meu login não esta correta.", Screenshot.capture());
        }
        return this;
    }

    private RegistraUsuarioStep criaUmaNovaContaDoUsuario() {
        registraUsuarioObject.nomeUmNovoUsuarioTextField().sendKeys(faker.name().name());
        registraUsuarioObject.emailDoUsuarioTextField().sendKeys(faker.internet().emailAddress());
        registraUsuarioObject.signupButton().click();
        Assert.assertEquals(registraUsuarioObject.visivelDeEnterAccountInformationLabel().getText(), "ENTER ACCOUNT INFORMATION");
        registraUsuarioObject.generoDoUsuarioCheckBox().click();
        String senhaDoUsuario = faker.internet().password();
        registraUsuarioObject.senhaDaContaDoUsuarioTextField().sendKeys(senhaDoUsuario);
        System.out.println("Senha: " + senhaDoUsuario);
        return this;
    }
}
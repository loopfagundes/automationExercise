package com.automationexercise.steps;

import com.automationexercise.pageobjects.RegistraUsuarioObject;
import com.automationexercise.utils.JsExcutor;
import com.automationexercise.utils.Screenshot;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
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
        informaDeEnderecoDoUsuario();
        validadoTelaDeCriaContaDoUsuario();
        return this;
    }

    private RegistraUsuarioStep telaDeIndex() {
        ExtentTestManager.getTest().log(Status.INFO, "A pagina da tela de index.");
        if (registraUsuarioObject.validadoTelaDeIndexLabel().isDisplayed()) {
            ExtentTestManager.getTest().log(Status.PASS, "A pagina da tela de index esta correta.");
        } else {
            JsExcutor.highlight(driver, registraUsuarioObject.validadoTelaDeIndexLabel());
            ExtentTestManager.getTest().log(Status.FAIL, "A pagina de index não esta correta.", Screenshot.capture());
        }
        Assert.assertEquals(registraUsuarioObject.validadoTelaDeIndexLabel().getText(), "AutomationExercise");
        if (registraUsuarioObject.acessaTelaDeLoginButton().isDisplayed()) {
            registraUsuarioObject.acessaTelaDeLoginButton().click();
            ExtentTestManager.getTest().log(Status.PASS, "O botao para acessa na tela de login esta recebendo um clique.");
        } else {
            JsExcutor.highlight(driver, registraUsuarioObject.acessaTelaDeLoginButton());
            ExtentTestManager.getTest().log(Status.FAIL, "O botao de acessa na tela de login nao esta recebendo um clique.", Screenshot.capture());
        }
        return this;
    }

    private RegistraUsuarioStep telaDeLoginDoUsuario() {
        Assert.assertEquals(registraUsuarioObject.visivelDeNewUserSignUpLabel().getText(), "New User Signup!");
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
        String nomeDoUsuario = faker.name().lastName();
        String sobreNomeDoUsuario = faker.name().lastName();
        registraUsuarioObject.nomeUmNovoUsuarioTextField().sendKeys(nomeDoUsuario);
        registraUsuarioObject.emailDoUsuarioTextField().sendKeys(faker.internet().emailAddress());
        registraUsuarioObject.signupButton().click();
        Assert.assertEquals(registraUsuarioObject.visivelDeEnterAccountInformationLabel().getText(), "ENTER ACCOUNT INFORMATION");
        ExtentTestManager.getTest().log(Status.INFO, "A pagina da tela de criar novo um usuario para fazer registra.");
        registraUsuarioObject.generoDoUsuarioCheckBox().click();
        String senhaDoUsuario = faker.internet().password();
        registraUsuarioObject.senhaDaContaDoUsuarioTextField().sendKeys(senhaDoUsuario);
        registraUsuarioObject.diaDeNascimentoDoUsuarioComboBox().selectByValue("20");
        registraUsuarioObject.mesDeNascimentoDoUsuarioComboBox().selectByValue("8");
        registraUsuarioObject.anoDeNascimentoDoUsuarioComboBox().selectByValue("1990");
        registraUsuarioObject.signUpForOurNewSletterCheckBox().click();
        registraUsuarioObject.receiveSpecialOffersFormOurPatnersCheckBox().click();
        Assert.assertEquals(registraUsuarioObject.visivelDeInformarEnderecoLabel().getText(), "ADDRESS INFORMATION");
        registraUsuarioObject.primeiroNomeDoUsuarioTextField().sendKeys(nomeDoUsuario);
        registraUsuarioObject.sobreNomeDoUsuarioTextField().sendKeys(sobreNomeDoUsuario);
        return this;
    }

    private RegistraUsuarioStep informaDeEnderecoDoUsuario() {
        registraUsuarioObject.empresaDoUsuarioTextField().sendKeys(faker.company().name());
        registraUsuarioObject.enderecoDoUsuarioTextField().sendKeys(faker.address().fullAddress());
        registraUsuarioObject.paisDoUsuarioComboBox().selectByValue("United States");
        registraUsuarioObject.estadoDoUsuarioTextField().sendKeys(faker.address().state());
        registraUsuarioObject.cidadeDoUsuarioTextField().sendKeys(faker.address().city());
        registraUsuarioObject.cepDoEnderecoDoUsuarioTextField().sendKeys(faker.address().zipCode());
        registraUsuarioObject.numeroDeContatoDoUsuarioTextField().sendKeys(faker.phoneNumber().cellPhone());
        if (registraUsuarioObject.criaContaDoUsuarioButton().isDisplayed()) {
            registraUsuarioObject.criaContaDoUsuarioButton().click();
            ExtentTestManager.getTest().log(Status.PASS, "O botão de criar conta esta recebendo um clique.");
        } else {
            JsExcutor.highlight(driver, registraUsuarioObject.criaContaDoUsuarioButton());
            ExtentTestManager.getTest().log(Status.FAIL, "O botão de criar conta não esta recebendo um clique.", Screenshot.capture());
        }
        return this;
    }

    private RegistraUsuarioStep validadoTelaDeCriaContaDoUsuario() {
        Assert.assertEquals(registraUsuarioObject.visivelDeContaCriaLabel().getText(), "ACCOUNT CREATED!");
        if (registraUsuarioObject.continuaButton().isDisplayed()) {
            registraUsuarioObject.continuaButton().click();
            ExtentTestManager.getTest().log(Status.PASS, "O botao de continua esta recebendo um clique.");
        } else {
            JsExcutor.highlight(driver, registraUsuarioObject.continuaButton());
            ExtentTestManager.getTest().log(Status.FAIL, "O botao de continua nao esta recebendo um clique.", Screenshot.capture());
        }
        Assert.assertEquals(registraUsuarioObject.visivelAdLabel().getText(), "Ad");
        registraUsuarioObject.fechaAdButton().click();
        System.out.println(registraUsuarioObject.visivelUsuarioEstaLogadoLabel().getText());
        return this;
    }
}
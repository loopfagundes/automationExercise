package com.automationexercise.steps;

import com.automationexercise.pageobjects.RegistraUsuarioObject;
import com.automationexercise.utils.JsExcutor;
import com.automationexercise.utils.Screenshot;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistraUsuarioStep {
    private final WebDriver driver;
    private final RegistraUsuarioObject registraUsuarioObject;

    public RegistraUsuarioStep(WebDriver _driver) {
        driver = _driver;
        registraUsuarioObject = new RegistraUsuarioObject(_driver);
    }

    public RegistraUsuarioStep efeturaLogin() {
        acessaTelaDeLogin();
        return this;
    }

    private RegistraUsuarioStep acessaTelaDeLogin() {
        ExtentTestManager.getTest().log(Status.INFO, "Acessa na tela de login.");
        if (registraUsuarioObject.validadoTelaDeIndexLabel().isDisplayed()) {
            ExtentTestManager.getTest().log(Status.PASS, "A pagina esta tela de login.");
        } else {
            JsExcutor.highlight(driver, registraUsuarioObject.validadoTelaDeIndexLabel());
            ExtentTestManager.getTest().log(Status.FAIL, "A pagina não esta correta.", Screenshot.capture());
        }
        Assert.assertEquals(registraUsuarioObject.validadoTelaDeIndexLabel().getText(), "AutomationExercise");
        registraUsuarioObject.acessaTelaDeLoginButton().click();
        return this;
    }
}
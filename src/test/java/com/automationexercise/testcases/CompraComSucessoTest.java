package com.automationexercise.testcases;

import com.automationexercise.utils.BaseTest;
import com.automationexercise.utils.Property;
import com.automationexercise.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CompraComSucessoTest extends BaseTest {

    @Test
    public void compraComSucessoTest() {
        WebDriver driver = DriverManager.getDriver();
        driver.get(Property.get("url"));
    }
}
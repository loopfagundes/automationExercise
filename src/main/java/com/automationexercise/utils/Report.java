package com.automationexercise.utils;

import com.aventstack.extentreports.service.ExtentTestManager;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Report implements ITestListener {
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().fail("Ocorreu uma falha no teste.", Screenshot.capture());
    }
}
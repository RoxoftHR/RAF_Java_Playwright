package org.raf3k.guittesting.webtesting.engine;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.raf3k.guittesting.webtesting.basetypes.WebControlBase;
import org.raf3k.guittesting.UIReferences;
import org.raf3k.shared.DebugLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raf3k.shared.SharedVariables;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class WebEngine {
    public WebEngine() {
        allAsyncLoaders = new ArrayList<By>();
    }

    private List<By> allAsyncLoaders = new ArrayList<By>();

    public WebElement findControl(String sControlType, String sControlPath, By searchBy, WebControlBase Parent, String sError, Boolean bDisplayed, Boolean bMustBeVisible, int iTimeoutOverride) {
        try {
            WebElement control = null;
            var timeSeconds = SharedVariables.configuration.getProperty("controlWaitTime");

            Duration waitTime = Duration.ofSeconds(Integer.parseInt(timeSeconds));
            if(iTimeoutOverride != -1)
                waitTime = Duration.ofSeconds(iTimeoutOverride);

            WebDriverWait wait = new WebDriverWait(UIReferences.getWebDriver(), waitTime);

            if (Parent == null) {
                control = wait.until(bMustBeVisible ? ExpectedConditions.visibilityOfElementLocated(searchBy) : ExpectedConditions.presenceOfElementLocated(searchBy));
            } else {
                control = (WebElement) wait.until(
                        ExpectedConditions.presenceOfNestedElementLocatedBy(Parent.control(), searchBy)
                );
            }

            return control;
        } catch (Exception e) {
            DebugLog.add("Error Finding control: " + sControlPath, 3);
            return null;
        }

    }

    /**
     * Checks if page loaded or not using JavaScript
     * @return Boolean if page loaded or not
     */
    public Boolean waitForPageLoading() {
        try {
            int waitTime = Integer.parseInt(SharedVariables.configuration.getProperty("pageLoadWaitTime"));
            WebDriverWait wait = new WebDriverWait(UIReferences.getWebDriver(), Duration.ofSeconds(waitTime));
            wait.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver) {
                    try {
                        var pageStatus = ((JavascriptExecutor) driver).executeScript("return document.readyState");
                        if(pageStatus == null || pageStatus.toString().equalsIgnoreCase("complete"))
                            return true;
                        return false;
                    } catch (Exception ex) {
                        return false;
                    }
                }
            });
            return true;
        } catch (Exception ex) {
            return false;

        }
    }
}

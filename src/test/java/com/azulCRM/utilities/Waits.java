package com.azulCRM.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    private static WebDriverWait getWait(){
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }

    //Explicit and Hard waits:
    public static void sleep(int sec){
        try{
            Thread.sleep(sec * 1000);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void waitTitle(String partialTitle){
        getWait().until(ExpectedConditions.titleContains(partialTitle));
    }

    public static void waitVisible(WebElement target){
        getWait().until(ExpectedConditions.visibilityOf(target));
    }

    public static void waitClickable(WebElement target){
        getWait().until(ExpectedConditions.elementToBeClickable(target));
    }

    public static void waitAndSwitchToFrame(WebElement frame){
        getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    public static void waitElementLocated(By by){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}

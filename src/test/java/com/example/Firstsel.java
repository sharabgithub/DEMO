package com.example;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Firstsel extends Base{
    WebDriver dr;

    @Test
    public void launchApp(){
        dr = WebDriverManager.chromedriver().create();
        dr = new ChromeDriver();
        dr.get("https://practicetestautomation.com/practice-test-login/");
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Base.initializeDriver();
    }

    @Test
    public void login() throws InterruptedException{
        dr.findElement(By.name("username")).sendKeys("student");
        dr.findElement(By.name("password")).sendKeys("Password123");
        dr.findElement(By.id("submit")).click();
        Thread.sleep(2000);
    }
    
}

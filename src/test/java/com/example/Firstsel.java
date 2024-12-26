package com.example;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Firstsel extends Base{

    @BeforeTest
    public void launchApp(){
       initializeDriver();
    }

    @Test
    public void login() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("student");
        driver.findElement(By.name("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
        System.out.println("This is login in First Test Class");
    }

    @AfterTest
    public void closeTest(){
        tearDown();
    }
    
}

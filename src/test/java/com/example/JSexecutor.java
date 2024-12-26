package com.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSexecutor {
    WebDriver driver;
    JavascriptExecutor js;

    @Test
    public void launch(){
        driver = WebDriverManager.chromedriver().create();
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor)driver;
    }

    @Test
    public void login() throws InterruptedException{
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }

    @Test (dependsOnMethods = "login")
    public void courses() throws InterruptedException{
        driver.findElement(By.xpath("//a[text()='Courses']")).click();
        js.executeScript("window.scrollBy(0, 1000)");
        Thread.sleep(1000);
        WebElement el_register = driver.findElement(By.xpath("//a[text()='Enroll in this course exclusively on Udemy']"));
        js.executeScript("arguments[0].scrollIntoView();", el_register);
        Thread.sleep(2000);
    }

    @Test
    public void printLinks(){
        List<WebElement> aLinks = driver.findElements(By.tagName("a"));
        for(WebElement al : aLinks){
            System.out.println(al.getText());
            System.out.println(al.getAttribute("href"));
            System.out.println(al.getAttribute("value"));
            System.out.println("==============================");
        }
    }
}

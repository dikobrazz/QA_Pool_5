package com.gmail.makarola;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;


public class TestMail {
    private static WebDriver driver;


    @BeforeClass
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver", "/home/makarola/IdeaProjects/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
        driver.get("http://mail.bigmir.net");


    }

    @Test
    public static void userLogin(){
        WebElement loginField = driver.findElement(By.id("login"));
        loginField.sendKeys("makarola@bigmir.net");
        WebElement passwordField = driver.findElement(By.id("pass"));
        // .//input[@name='password']
        passwordField.sendKeys("love14072001");
        passwordField.submit();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[contains(., 'makarola@bigmir.net')]")));
        WebElement profileUser = driver.findElement(By.xpath(".//a[contains(., 'makarola@bigmir.net')]"));
        String mailUser = profileUser.getText();
        Assert.assertEquals("makarola@bigmir.net", mailUser);

    }

    @AfterClass
    public  static  void  tearDown(){
        WebElement userQuit = driver.findElement(By.xpath("//span[text()='Выйти']"));
        userQuit.click();
        driver.close();

    }
    }




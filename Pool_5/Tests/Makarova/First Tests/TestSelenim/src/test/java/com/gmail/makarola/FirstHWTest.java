package com.gmail.makarola;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class FirstHWTest {

    private static WebDriver driver;

    @BeforeClass
        public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "/home/makarola/IdeaProjects/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");

    }

    @Test
    public static void testPage(){

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("автотесты");
        searchField.submit();

        WebElement searchLink = driver.findElement(By.xpath("//a[contains(., ' Заметки Автоматизатора')]"));
        Assert.assertEquals(searchLink.isDisplayed(), true);
        searchLink.click();

        WebElement searchResult = driver.findElement(By.xpath("//h1[contains(., 'Как писать автотесты быстро')]"));
        Assert.assertEquals(searchResult.getText(), "Как писать автотесты быстро");

    }

    @AfterClass
    public static void endTest(){
        driver.close();
    }

}

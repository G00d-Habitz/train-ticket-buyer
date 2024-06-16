package com.traintickets.buyer.service;


import com.traintickets.buyer.entity.Ticket;
import com.traintickets.buyer.entity.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import java.time.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Service
public class BuyerService {

    public static void logInKoleo(Ticket ticket, User user) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://koleo.pl/signin");
        TimeUnit.SECONDS.sleep(5);

        WebElement emailBox = driver.findElement(new By.ByXPath("/html/body/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/form/div[1]/input"));
        WebElement passwordBox = driver.findElement(new By.ByXPath("/html/body/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/form/div[2]/input"));
        WebElement submitLogin = driver.findElement(new By.ByXPath("/html/body/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/form/input"));

        emailBox.sendKeys(user.getEmail());
        passwordBox.sendKeys(user.getPassword());

        submitLogin.click();

        driver.quit();
    }

}

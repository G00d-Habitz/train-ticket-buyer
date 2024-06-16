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
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        TimeUnit.SECONDS.sleep(2);

        WebElement emailBox = driver.findElement(new By.ByXPath("/html/body/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/form/div[1]/input"));
        WebElement passwordBox = driver.findElement(new By.ByXPath("/html/body/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/form/div[2]/input"));
        WebElement submitLogin = driver.findElement(new By.ByXPath("/html/body/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/form/input"));
        emailBox.sendKeys(user.getEmail());
        TimeUnit.SECONDS.sleep(1);

        passwordBox.sendKeys(user.getPassword());
        TimeUnit.SECONDS.sleep(1);

        submitLogin.click();
        TimeUnit.SECONDS.sleep(2);

        driver.get(String.format("https://koleo.pl/rozklad-pkp/%s/%s/%s/all/all", ticket.getStartingStation(), ticket.getDestination(), ticket.getDepartureTime()));
        TimeUnit.SECONDS.sleep(5);

        /*


        PLACE FOR CODE RESPONSIBLE FOR CHOOSING THE RIGHT TRAIN

         */

        // The part that is supposed to buy a ticket
        WebElement trainToClick = driver.findElement(new By.ByXPath("/html/body/div[2]/div/div[2]/div[2]/section[1]/div[2]/div[1]/div"));

        trainToClick.click();
        TimeUnit.SECONDS.sleep(5);
        WebElement buyTicketButton = driver.findElement(new By.ByXPath("/html/body/div[2]/div/div[2]/div[2]/section[1]/div[2]/div[1]/div/div[2]/section/div[3]/button"));
        buyTicketButton.click();
        TimeUnit.SECONDS.sleep(5);
        WebElement nextButton = driver.findElement(new By.ByXPath("/html/body/div[2]/div/div[2]/div[2]/div[3]/div/div[2]/div[2]/div/button"));
        nextButton.click();
        TimeUnit.SECONDS.sleep(5);
        nextButton = driver.findElement(new By.ByXPath("/html/body/div[2]/div/div[3]/div[4]/div/button"));
        nextButton.click();
        nextButton = driver.findElement(new By.ByXPath("/html/body/div[1]/div/div/div/div[2]/div[2]"));
        nextButton.click();
        TimeUnit.SECONDS.sleep(5);
        WebElement paymentOptionButton = driver.findElement(new By.ByXPath("/html/body/div[1]/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/label/div/span[1]"));
        paymentOptionButton.click();
        TimeUnit.SECONDS.sleep(5);
        driver.quit();
    }

}

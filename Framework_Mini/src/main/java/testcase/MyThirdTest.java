package testcase;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ReadxlsFile;

import java.time.Duration;


@Listeners(utilities.TestngListeners.class)
public class MyThirdTest extends BaseClass {


    @Test()
    public void RegistrationFORM() throws InterruptedException {

        driver.findElement(By.id(locators.getProperty("usernamefild"))).sendKeys("standard_user");

        driver.findElement(By.id(locators.getProperty("passwordfild"))).sendKeys("secret_sauce");

        Thread.sleep(2000);

        driver.findElement(By.id(locators.getProperty("loginbutton"))).click();

        System.out.println("Login SuccessFull");


    }

    @Test(priority = 2)
    public void addItemInCart() throws InterruptedException {


        driver.findElement(By.xpath(locators.getProperty("item"))).click();

        driver.findElement(By.xpath(locators.getProperty("addtocartfild"))).click();

        System.out.println("Item Add into Cart");


        WebElement cart = driver.findElement(By.id(locators.getProperty("cart")));


        cart.click();


        driver.findElement(By.xpath(locators.getProperty("checkoutbutton"))).click();

        System.out.println("Item Checkout");

        Thread.sleep(2000);


    }

    @Test(priority = 3)
    public void itemCheckout() throws InterruptedException {

        driver.findElement(By.id(locators.getProperty("firstName"))).sendKeys("Akshay");

        System.out.println("firstName Add ");

        driver.findElement(By.id(locators.getProperty("lastName"))).sendKeys("Bokhare");

        System.out.println("lastName Add ");

        driver.findElement(By.id(locators.getProperty("postalCode"))).sendKeys("412218");

        System.out.println("postalCode Add ");

        Thread.sleep(2000);

        driver.findElement(By.xpath(locators.getProperty("continuedbutton"))).click();

        Thread.sleep(2000);

        System.out.println("Checkout Info Fill SuccessFull");


        driver.findElement(By.xpath(locators.getProperty("finishButton"))).click();

        System.out.println("THANK YOU FOR YOUR ORDER");


    }


}

package testcase;


import base.BaseClass;

import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MyFirstTest extends BaseClass {


    @Test(priority = 1)
    public void loginTest() throws InterruptedException {


        //****This Is Manual ****//

//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        logger.info("User Name Inter SucessFully");
//        Thread.sleep(2000);
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        logger.info("Password Inter SucessFully");
//
//        Thread.sleep(2000);
//        driver.findElement(By.id("login-button")).click();
//        logger.info("LOgs In login");
//
//        logger.info("Login SusessFull");


        // ******************************************************************************//

        //*****This Is Using Locators ****//

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

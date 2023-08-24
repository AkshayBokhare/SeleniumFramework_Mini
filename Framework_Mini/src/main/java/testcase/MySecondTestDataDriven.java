package testcase;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import utilities.ReadxlsFile;

public class MySecondTestDataDriven extends BaseClass {


    @Test(dataProviderClass = ReadxlsFile.class,dataProvider = "testData")
    public void loginTest(String username, String password) throws InterruptedException {


        WebElement userName = driver.findElement(By.id(locators.getProperty("usernamefild")));
        userName.clear();
        userName.sendKeys(username);


        WebElement userPassword = driver.findElement(By.id(locators.getProperty("passwordfild")));
        userPassword.clear();
        userPassword.sendKeys(password);


        driver.findElement(By.id(locators.getProperty("loginbutton"))).click();

        Thread.sleep(2000);

        WebElement tittle = driver.findElement(By.xpath("//div[text()='Products']"));

        Assert.assertTrue(tittle.isDisplayed());

//        Assert.assertEquals(driver.getTitle(),);


    }

}



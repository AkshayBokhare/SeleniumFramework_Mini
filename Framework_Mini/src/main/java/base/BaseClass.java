package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class BaseClass {

    public static WebDriver driver;
    public static Properties properties = new Properties();
    public static Properties locators = new Properties();
    public static FileReader fileReader;
    public static FileReader fileReader2;

    @BeforeTest
    public void setup() throws IOException {
        if (driver == null) {

            //** This fileReader is For Load Driver & URL **//

            fileReader = new FileReader("C:\\Users\\NTS-Akshay Bokhare\\IdeaProjects\\SeleniumProject\\Framework_Mini\\src\\main\\resources\\configfiles\\config.properties");

            properties.load(fileReader);


            //** This fileReader is For Load Locators **//
            fileReader2 = new FileReader("C:\\Users\\NTS-Akshay Bokhare\\IdeaProjects\\SeleniumProject\\Framework_Mini\\src\\main\\resources\\configfiles\\locators.properties");

            locators.load(fileReader2);


        }

        if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(properties.getProperty("testurl"));
            driver.manage().window().maximize();

            System.out.println("Chrome Driver Open SuccessFully");


        } else if (properties.getProperty("browser").equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

            driver.get(properties.getProperty("testurl"));

            driver.manage().window().maximize();

            System.out.println("FireFox Driver Open SuccessFully");
        }
    }


    public void CaptureScreenshot(WebDriver driver, String testName) throws IOException {

        String timeStamp = new SimpleDateFormat("YYYY.mm.dd.hh.mm.ss").format(new Date());
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);


        //  File trg = new File("C:\\Users\\NTS-Akshay Bokhare\\IdeaProjects\\SeleniumProject\\Framework_Mini\\src\\main\\resources\\screenshots\\"+testName+timeStamp+".png");


        File trg = new File(System.getProperty("user.dir") + "\\screenshots\\" + testName + timeStamp + ".png");

        FileUtils.copyFile(src, trg);
        System.out.println("ScreenShot Capture ");

    }


    @AfterTest
    public void closeSetup() {
        driver.quit();

        System.out.println("Driver Quit SuccessFully");
    }

}

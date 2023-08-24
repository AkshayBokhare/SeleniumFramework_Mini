package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadpropertiFile {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("C:\\Users\\NTS-Akshay Bokhare\\IdeaProjects\\SeleniumProject\\Framework_Mini\\src\\main\\resources\\configfiles\\config.properties");

        Properties properties = new Properties();
        properties.load(fileReader);

        System.out.println(properties.getProperty("browser"));
        System.out.println(properties.getProperty("testurl"));
    }
}

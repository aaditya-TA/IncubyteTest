package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException
    {

        prop= new Properties();
        FileInputStream fis=new FileInputStream("src\\main\\java\\resources\\data.properties");

        prop.load(fis);
        String browserName=prop.getProperty("browser");
        System.out.println(browserName);

        if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver= new ChromeDriver();
            driver.manage().window().maximize();

        }
        else if (browserName.equals("firefox"))
        {
            driver= new FirefoxDriver();
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;


    }


}

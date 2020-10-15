import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumCrawling {
    private WebDriver driver;
    private WebElement element;

    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "/usr/local/bin/chromedriver";

    private String baseUrl;

    public SeleniumCrawling(){
        super();

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);

        driver = new ChromeDriver(options);
        baseUrl = "https://www.naver.com";
    }

    public void test(){
        try {
            driver.get(baseUrl);
            System.out.println(driver.getTitle());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.close();
        }
    }


}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class SeleniumCrawling {
    private WebDriver driver;
    private WebElement element;

    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "/usr/local/bin/chromedriver";

    private String baseUrl;
    private String keyWord;

    public SeleniumCrawling() {
        super();

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);

        driver = new ChromeDriver(options);
        baseUrl = "https://www.google.co.kr/";
        keyWord = "JAVA";
    }

    public void test() {
        File file = new File("test.text");

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            driver.get(baseUrl);
            element = driver.findElement(By.name("q"));
            element.sendKeys(keyWord);
            element.submit();

            List<WebElement> titles = driver.findElements(By.className("LC20lb"));
            int index = 0;
            bufferedWriter.append("검색 키워드 -> " + keyWord + "\n");
            for (WebElement title : titles) {
                index++;
                System.out.println("제목 : " + title.getText() + "\n");
                bufferedWriter.append("제목 : " + title.getText() + "\n");
            }
            System.out.println("총 검색 건수 : " + index);
            bufferedWriter.append("총 검색 건수 : " + index);

            bufferedWriter.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
    }


}

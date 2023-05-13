import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoginTest {
    private WebDriver driver;
    private String filePath = "C:\\Users\\isaac\\IdeaProjects\\test-selenium\\src\\main\\resources\\case.csv";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void testLogin() throws IOException {
        List<Map<String, String>> cases = ReadCSV.read(filePath);
        // 遍历每一个用例
        for (Map<String, String> map : cases) {
            System.out.println("用例:");
            System.out.println(map.get("username")+" "+map.get("password")+" ");
            driver.get("http://localhost:1080/WebTours/index.htm");
            driver.manage().window().maximize();
            driver.switchTo().frame(1);
            driver.switchTo().frame(0);
            driver.findElement(By.name("username")).click();
            driver.findElement(By.name("username")).sendKeys(map.get("username"));
            driver.findElement(By.name("password")).click();
            driver.findElement(By.name("password")).sendKeys(map.get("password"));
            driver.findElement(By.name("login")).click();
            driver.switchTo().defaultContent();
            driver.switchTo().frame(1);
            driver.switchTo().frame(1);
            try {
                driver.findElement(By.xpath("/html/body/blockquote/center/h3/font")).click();
                String actual = driver.findElement(By.xpath("/html/body/blockquote/center/h3/font")).getText();
                String expected = map.get("expected");
                try {
                    Assertions.assertEquals(expected, actual);
                } catch (AssertionError ae) {
                    ae.printStackTrace();
                }
            } catch (NoSuchElementException e) {
                driver.findElement(By.xpath("/html/body/blockquote")).click();
                String actual = driver.findElement(By.xpath("/html/body/blockquote")).getText();
                String expected = map.get("expected");
                try {
                    Assertions.assertTrue(actual.contains(expected));
                } catch (AssertionError ae) {
                    ae.printStackTrace();
                }

            }
        }
        driver.close();
    }
}

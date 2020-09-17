import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;

public class FunctionalTests {
    private WebDriver driver;


    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com");
    }

    @Test(priority = 1)
    public void checkTheNameOfTheHeadlineArticle() {
        driver.findElement(xpath("//*[@id=\"orb-nav-links\"]/ul/li[2]/a")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(xpath("//*[@id=\"sign_in\"]/div/button")).click();
        driver.findElement(xpath("//*[@id=\"u7764844584295436\"]/div/div/div/div[1]/div/div/div[1]/div/a/h3"));
        String actualResult =
                driver.findElement(xpath("//*[@id=\"u7764844584295436\"]/div/div/div/div[1]/div/div/div[1]/div/a/h3")).getText();
        assertEquals(actualResult, "WHO warns of 'very serious situation' in Europe");
    }

    @Test(priority = 2)
    public void checkSecondaryArticleTitle() {
        driver.findElement(xpath("//*[@id=\"orb-nav-links\"]/ul/li[2]/a")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(xpath("//*[@id=\"sign_in\"]/div/button")).click();
        driver.findElement(xpath("//*[@id=\"u7764844584295436\"]/div/div/div/div[3]/div/div[2]/div/a/h3"));
        String actualResult =
                driver.findElement(xpath("//*[@id=\"u7764844584295436\"]/div/div/div/div[3]/div/div[2]/div/a/h3")).getText();
        assertEquals(actualResult, "Navalny's aides say poison found on water bottle");
    }

    @Test(priority = 3)
    public void checkTheNameOfTheFirstArticleSearch() {
        driver.findElement(xpath("//*[@id=\"orb-nav-links\"]/ul/li[2]/a")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(xpath("//*[@id='sign_in']/div/button")).click();
        driver.findElement(xpath("//*[@id=\"orb-search-q\"]")).sendKeys("world", Keys.ENTER);
        String actualResult =
                driver.findElement(xpath("//*[@id=\"main-content\"]/div[3]/div/div/ul/li[2]/div/div[1]/div[1]/p[1]/a/span")).getText();
        assertEquals(actualResult, "World's End: World's End");

    }

    @Test (priority = 4)
    public void verifiesThatUserCanSubmitAQuestionToBBC() {
        driver.findElement(xpath("//*[@id=\"orb-nav-links\"]/ul/li[2]/a")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(xpath("//*[@id='sign_in']/div/button")).click();
        driver.findElement(xpath("//*[@id=\"orb-modules\"]/header/div[2]/div/div[1]/nav/ul/li[3]/a/span")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(xpath("//*[@id=\"orb-modules\"]/header/div[2]/div[2]/div[1]/nav/ul/li[2]/a/span[1]")).click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(xpath("//*[@id=\"index-page\"]/div/div[2]/div[2]/div[1]/div/div[2]/div/a")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(xpath("//div[@class='embed-content-container']//button[@class='button']")).click();
        String actualResult =
                driver.findElement(xpath("//*[@id=\"page\"]/div[1]/div[2]/div/div[1]/div[1]/div[2]/p[25]")).getText();
        assertEquals(actualResult, "Use this form to let us know:");

    }


}

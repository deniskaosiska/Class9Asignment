import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class Main {
    private static WebDriver driver;
    private static WebDriver driver1;


//    @BeforeTest
//    public static void beforeTestFirefox() {
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Denis.Kozyra\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.selenium.dev/");
//    }
    @BeforeTest
    public static void beforeTestChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Denis.Kozyra\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get("https://dgotlieb.github.io/WebCalculator/");
    }
    @Test
    public void exercise1(){


        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Denis.Kozyra\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get("https://www.ynet.co.il/");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Denis.Kozyra\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
                driver1 = new ChromeDriver();
                driver1.manage().window().maximize();
                driver1.get("https://www.walla.co.il/");
    }
    @Test
    public void exercise2(){

        String webtitle = driver.getTitle();
        System.out.println(webtitle);
        driver.navigate().refresh();
        String webtitlenew = driver.getTitle();
        System.out.println(webtitlenew);
        Assert.assertEquals(webtitlenew,webtitle);
    }
    @Test
    public void exercise3(){
        String webURL = driver.getCurrentUrl();
        System.out.println(webURL);
        Assert.assertEquals(driver.getCurrentUrl(),webURL);
    }

    @Test
    public void exercise4(){
        System.out.println(driver1.findElement(new ByChained(By.tagName("textarea"),By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[2]/c-wiz[1]/span/span/div/textarea"))));
    }

    @Test
    public void exercise5(){
        System.out.println(driver.findElement(By.id("logo-icon")));
    }

    @Test
    public void exercise6(){
        System.out.println(driver.findElement(By.name("search")));
        driver.findElement(By.name("search")).sendKeys("selenium");
    }

    @Test
    public void exercise7(){
        String webtitle = driver1.getTitle();
        System.out.println(webtitle);
        Assert.assertEquals(webtitle, "Amazon.com. Spend less. Smile more.");
        driver1.findElement(By.id("twotabsearchtextbox")).sendKeys("Leather shoes");
        driver1.findElement(By.id("nav-search-submit-button")).click();
    }

    @Test
    public void exercise8(){
        driver1.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[2]/c-wiz[1]/span/span/div/textarea")).sendKeys("שלום, זה בדיקה");
    }

    @Test
    public void excercise9(){
        driver1.findElement(By.id("search")).sendKeys("yellow submarine");
        driver1.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]/yt-icon")).click();
    }

    @Test
    public void exercise10(){
        driver1.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/input[3]")).click();
        Select mySelect = new Select(driver1.findElement(By.name("dropdownmenu")));
        mySelect.selectByValue("Milk");
        List<WebElement> e = mySelect.getOptions();

        for (int i = 0; i <= e.size(); i++) {
            System.out.println(e.get(i).getText());
        }
    }

    @Test
    public void exercise11(){
        driver1.findElement(By.name("email")).sendKeys("Username");
        driver1.findElement(By.name("pass")).sendKeys("Password");
        driver1.findElement(By.name("login")).click();
    }

    @Test
    public void exercise12(){
        System.out.println("7 button height is "+ driver1.findElement(By.xpath("//*[@id=\"seven\"]")).getRect().getHeight());
        System.out.println("7 button width is " + driver1.findElement(By.xpath("//*[@id=\"seven\"]")).getRect().getWidth());
        System.out.println("6 button is displayed " + driver1.findElement(By.xpath("//*[@id=\"six\"]")).isDisplayed());
        String num = "5";
        driver1.findElement(By.xpath("//*[@id=\"three\"]")).click();
        driver1.findElement(By.xpath("//*[@id=\"add\"]")).click();
        driver1.findElement(By.xpath("//*[@id=\"two\"]")).click();
        driver1.findElement(By.xpath("//*[@id=\"equal\"]")).click();
        String result = driver1.findElement(By.xpath("//*[@id=\"screen\"]")).getText();
        //System.out.println(result);
        Assert.assertEquals(result, num);
    }

    @Test
    public void exercise13(){
       System.out.println("2 button height is " + driver1.findElement(By.xpath("//*[@id=\"two\"]")).getRect().getHeight());
       System.out.println("6 button width is " + driver1.findElement(By.xpath("//*[@id=\"six\"]")).getRect().getWidth());
    }

//    @Test
//    public void exercise14(){
//       //I entered to in Chrome browser to "More tools" --"Extension" and disable all extensions that I have
//    }

    @Test
    public void exercise15(){
        JavascriptExecutor js = (JavascriptExecutor) driver1;
        js.executeScript("document.getElementById('three').click()");
    }
//    exercise16 - in TESTNG we can use tags (ChromeTest and FirefoxTest) that we can run test cases at the same tome on different browsers.
//    Also we can use Online tools:
//    LambdaTest.
//Ghost Inspector.
//Browsera.
//Perfecto.
//Experitest.
//Sauce Labs.
//Browserling
//


    @AfterClass
    public static void tearDownFirefox(){
        driver.quit();
    }

    @AfterClass
    public static void tearDownChrome(){
        driver1.quit();
    }

}

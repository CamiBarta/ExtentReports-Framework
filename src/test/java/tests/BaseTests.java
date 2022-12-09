package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTests {

    protected WebDriver driver;

    protected ExtentSparkReporter sparkReporter;
    protected ExtentReports extentReports;
    protected ExtentTest test;

    protected BasePage basePage;
    protected HomePage homePage;
    protected StorePage storePage;
    protected ProductShopPage productShopPage;
    protected ShopPanelPage shopPanelPage;
    protected ShoppingCartPage shoppingCartPage;
    protected PersonalInfoPage personalInfoPage;
    protected DeliveryPage deliveryPage;
    protected PaymentPage paymentPage;
    protected ShippingMethodPage shippingMethodPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        storePage = new StorePage(driver);
        productShopPage = new ProductShopPage(driver);
        shopPanelPage = new ShopPanelPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        personalInfoPage = new PersonalInfoPage(driver);
        deliveryPage = new DeliveryPage(driver);
        paymentPage = new PaymentPage(driver);
        shippingMethodPage = new ShippingMethodPage(driver);

        basePage.goToUrl();
    }

    @BeforeTest
    public void setExtent() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String repName = "testReport " + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports/" + repName);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Tester Name", "Cami");
        extentReports.setSystemInfo("Browser", "Chrome");
    }

    @AfterTest
    public void endReport() {
        extentReports.flush();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test case FAILED is " + result.getName());
            test.log(Status.FAIL, "Test case FAILED is " + result.getThrowable());

            String screenshotPath = takeScreenshots(result.getName());
            test.addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test case SKIPPED is " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test case PASSED is " + result.getName());
        }
    }

    public String takeScreenshots(String screenshotName) throws IOException {
        String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "//screenshots/" + date + ".png";
        File finalDest = new File(dest);
        FileUtils.copyFile(source, finalDest);

        return dest;
    }

    public void createTests(String name) {
        test = extentReports.createTest(name);
    }
}

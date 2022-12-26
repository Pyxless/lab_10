package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.ForManPAge;
import pageobject_model.HomePage;

public class StaffTests {
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void browserSetup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public  void AddElementForManInFavorites()
    {
        int expected = 1;
        int result = new ForManPAge(driver)
                .openPage()
                .AddInFavorites()
                .openFavoritesPage()
                .CheckElementInFavorites();
        Assert.assertTrue(expected == result,String.valueOf(result));
    }
    @Test
    public void SearchSnickers()
    {
        String expected = "Зимние кроссовки Staff gray & black";
        String result = new HomePage(driver)
                .openPage()
                .searchQuery("Зимние кроссовки Staff gray black")
                .SearchingResult();
        Assert.assertTrue(expected.equals(result),result);
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown()
    {
//        driver.quit();
        driver = null;
    }
}

package pageobject_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private String str;

//    @FindBy(xpath = "//h2[@class='pt-title']/a")
//    private WebElement result_element;


    public SearchPage(WebDriver driver,String str)
    {
        this.driver = driver;
        this.str = str;
        PageFactory.initElements(driver,str);
    }
    public String SearchingResult()
    {
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[@class='pt-title']/a")));
        WebElement result_element = driver.findElement(By.xpath("//h2[@class='pt-title']/a"));
        String result = result_element.getText();
        return result;
    }
}

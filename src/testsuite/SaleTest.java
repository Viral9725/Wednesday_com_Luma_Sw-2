package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    //Method verifyTheTotalItemsDisplayedOnTheWomensJacketsPage
    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage()
    {
        WebElement saleTabLink = driver.findElement(By.linkText("Sale"));
        saleTabLink.click();
        WebElement jacketsLink = driver.findElement(By.linkText("Jackets"));
        jacketsLink.click();
        String expectedMessage1 = "Jackets";
        WebElement actualTextElement0 = driver.findElement(By.id("page-title-heading"));
        String actualMessage1 = actualTextElement0.getText();
        Assert.assertEquals("The Jackets page is not loaded", expectedMessage1,actualMessage1);


        //Count the Total Item Displayed on Page and print the name of all items into console.
        int expectedItemsDisplayed = 12;
        List<WebElement> items = driver.findElements(By.xpath("//strong[@class = " + "'product name product-item-name']//a"));
        int actualItemsDisplayed = items.size();
        System.out.println("--------------------------");
        System.out.println("Name of all Items");
        for (int i = 1; i <= items.size(); i++) {
            String itemNames = driver.findElement(By.xpath("(//strong[@class = " + "'product name product-item-name']//a)[" + i + "]")).getText();
            System.out.println(itemNames);
        }
        Assert.assertEquals("Expected number of products are not displayed", expectedItemsDisplayed, actualItemsDisplayed);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}

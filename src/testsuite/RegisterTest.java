package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay(){

        WebElement createAnAccount = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[3]/a"));
        createAnAccount.click();

        String expectedMessage = "Create New Customer Account";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='base']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Invalid email or password is not displayed", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully(){

        WebElement createAnAccount1 = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[3]/a"));
        createAnAccount1.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
        firstName.sendKeys("viral");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastname']"));
        lastName.sendKeys("kakadiya");

        WebElement checkList = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkList.click();

        WebElement emailId = driver.findElement(By.xpath( "//input[@id='email_address']"));
        emailId.sendKeys("viralKakadiya2002@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Viralkakadiya9780@gmail.com");

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@name='password_confirmation']"));
        confirmPassword.sendKeys("Viralkakadiya9780@gmail.com");

        WebElement createAnAccountButton = driver.findElement(By.xpath("//button[@class='action submit primary']"));
        createAnAccountButton.click();

        String expectedMessage = "Thank you for registering with Main Website Store.";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[contains(text(),'Thank you for registering with Main Website Store.')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Invalid email or password is not displayed", expectedMessage, actualMessage);

        WebElement welcomeDropDownButton = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button"));
        welcomeDropDownButton.click();
        WebElement signOut = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a"));
        signOut.click();

        String expectedMessage1 = "You are signed out";
        WebElement actualTextElement1 = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span"));
        String actualMessage1 = actualTextElement1.getText();
        Assert.assertEquals("Customer is not signed out", expectedMessage1, actualMessage1);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}

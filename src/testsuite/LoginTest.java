package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    final String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        WebElement emailField = driver.findElement(By.name("login[username]"));
        emailField.sendKeys("viralKakadiya2005@gmail.com");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("Viralkakadiya9780@gmail.com");
        WebElement signInLink2 = driver.findElement(By.xpath("//*[@id=\"send2\"]/span"));
        signInLink2.click();
        String expectedMessage = "Welcome, Viral Kakadiya!";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[contains(text(),'Viral Kakadiya!,')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("User not logged in successfully", expectedMessage, actualMessage);

    }

    //method verifyTheErrorMessageWithInvalidCredentials
    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        WebElement emailField = driver.findElement(By.name("login[username]"));
        emailField.sendKeys("viralKakadiya2005@gmail.com");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("Viralkakadiya9780@gmail.com");
        WebElement signInLink2 = driver.findElement(By.xpath("//*[@id=\"send2\"]/span"));
        signInLink2.click();
        String expectedMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='message-error error message']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);
    }

    //userShouldLogOutSuccessfully method
    @Test
    public void userShouldLogOutSuccessfully() {
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        WebElement emailField = driver.findElement(By.name("login[username]"));
        emailField.sendKeys("viralKakadiya2002@gmail.com");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("Viralkakadiya9780@gmail.com");
        WebElement signInLink2 = driver.findElement(By.xpath("//*[@id=\"send2\"]/span"));
        signInLink2.click();
        WebElement welcomeDropDownButton = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button"));
        welcomeDropDownButton.click();
        WebElement signOut = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a"));
        signOut.click();
        String expectedMessage1 = "You are signed out";
        WebElement actualTextElement1 = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span"));
        String actualMessage1 = actualTextElement1.getText();
        Assert.assertEquals("User is not signed out", expectedMessage1, actualMessage1);
    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}

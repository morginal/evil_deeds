package ru.stqa.evil_deeds.addressbook;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import sun.font.Script;

public class NewUserAddingTests
{
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception
    {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("/opt/firefox_46.0.1/firefox/firefox"));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        wd.get("http://localhost/addressbook/edit.php");
        login("admin", "secret");
    }
    
    @Test
    public void newUserCreation() throws Exception
    {
        initiateAddUser();
        fillUserData(new UserData("John", "Constantine", "89285555228", "test@trashmail.me"));
        submitUserCard();
        checkUserAdded();
    }

    private void checkUserAdded() throws Exception
    {
        List<WebElement> s = wd.findElements(By.xpath("//td[2]"));
        System.out.println("there is " + s.size() + " user(s) row(s)");
        if (s.size() != 1)
        {
            throw new Exception("something went wrong");
        }
    }

    private void submitUserCard()
    {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void fillUserData(UserData userData)
    {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(userData.getUsername());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(userData.getUserLastname());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(userData.getPhone());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(userData.getEmail());
    }

    private void initiateAddUser()
    {
        wd.findElement(By.linkText("add new")).click();
    }

    private void login(String username, String password)
    {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    @AfterMethod
    public void tearDown()
    {
        deleteUserRow();
        wd.quit();
    }

    private void deleteUserRow()
    {
        wd.findElement(By.xpath("//*[@id='MassCB']")).click();
        wd.findElement(By.xpath("//*[@value='Delete']")).click();
        wd.switchTo().alert().accept();
    }

    public static boolean isAlertPresent(FirefoxDriver wd)
    {
        try
        {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e)
        {
            return false;
        }
    }
}

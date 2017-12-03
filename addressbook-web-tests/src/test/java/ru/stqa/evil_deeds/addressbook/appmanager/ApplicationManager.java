package ru.stqa.evil_deeds.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.stqa.evil_deeds.addressbook.model.UserData;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApplicationManager
{
    FirefoxDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;

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

    public void init()
    {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("/opt/firefox_46.0.1/firefox/firefox"));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);

        wd.get("http://localhost/addressbook/index.php");
        sessionHelper.login("admin", "secret");
    }

    public void stop()
    {
        wd.quit();
    }

    public void checkUserAdded() throws Exception
    {
        List<WebElement> s = wd.findElements(By.xpath("//td[2]"));
        System.out.println("there is " + s.size() + " user(s) row(s)");
        if (s.size() != 1)
        {
            throw new Exception("something went wrong");
        }
    }

    public void submitUserCard()
    {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillUserData(UserData userData)
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

    public void initiateAddUser()
    {
        wd.findElement(By.linkText("add new")).click();
    }

    public void deleteUserRow()
    {
        wd.findElement(By.xpath("//*[@id='MassCB']")).click();
        wd.findElement(By.xpath("//*[@value='Delete']")).click();
        wd.switchTo().alert().accept();
    }

    public GroupHelper getGroupHelper()
    {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper()
    {
        return navigationHelper;
    }
}

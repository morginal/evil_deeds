package ru.stqa.evil_deeds.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.stqa.evil_deeds.addressbook.model.GroupData;
import ru.stqa.evil_deeds.addressbook.model.UserData;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApplicationManager
{
    FirefoxDriver wd;

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

        wd.get("http://localhost/addressbook/index.php");
        login("admin", "secret");
    }

    private void login(String user, String password)
    {
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(user);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void submitGroupCreation()
    {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData)
    {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void initGroupCreation()
    {
        wd.findElement(By.name("new")).click();
    }

    public void returnToGroupPage()
    {
        wd.findElement(By.linkText("groups")).click();
    }

    public void gotoGroupPage()
    {
        wd.findElement(By.linkText("groups")).click();
    }

    public void stop()
    {
        wd.quit();
    }

    public void deleteSelectedGroups()
    {
        wd.findElement(By.name("delete")).click();
    }

    public void selectGroup()
    {
        if (!wd.findElement(By.name("selected[]")).isSelected())
        {
            wd.findElement(By.name("selected[]")).click();
        }
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
}
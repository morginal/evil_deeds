package ru.stqa.evil_deeds.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.evil_deeds.addressbook.model.UserData;

import java.util.List;

public class UserHelper extends HelperBase
{
    public UserHelper(FirefoxDriver wd)
    {
        super(wd);
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
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillUserData(UserData userData)
    {
        type(By.name("firstname"), userData.getUsername());
        type(By.name("lastname"), userData.getUserLastname());
        type(By.name("mobile"), userData.getPhone());
        type(By.name("email"), userData.getEmail());
    }

    public void initiateAddUser()
    {
        click(By.linkText("add new"));
    }

    public void deleteUserRow()
    {
        click(By.xpath("//*[@id='MassCB']"));
        click(By.xpath("//*[@value='Delete']"));
        wd.switchTo().alert().accept();
    }
}

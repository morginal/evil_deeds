package ru.stqa.evil_deeds.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.evil_deeds.addressbook.model.ContactData;

import java.util.List;

public class ContactHelper extends HelperBase
{
    public ContactHelper(WebDriver wd)
    {
        super(wd);
    }

    public void checkContactAdded() throws Exception
    {
        List<WebElement> s = wd.findElements(By.xpath("//td[2]"));
        System.out.println("there is " + s.size() + " user(s) row(s)");
        if (s.size() < 1)
        {
            throw new Exception("something went wrong");
        }
    }

    public void submitContactCard()
    {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactData(ContactData contactData)
    {
        type(By.name("firstname"), contactData.getContactname());
        type(By.name("lastname"), contactData.getContactLastname());
        type(By.name("mobile"), contactData.getPhone());
        type(By.name("email"), contactData.getEmail());
    }

    public void initiateAddContact()
    {
        click(By.linkText("add new"));
    }

    public void deleteContact()
    {
        click(By.xpath("//table[@id='maintable']//input"));
        click(By.xpath("//*[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void goContactPage()
    {
        click(By.linkText("home"));
    }

    public void initContactModification()
    {
        click(By.xpath("//*[@title='Edit']"));
    }

    public void returnToContactPage()
    {

    }
}

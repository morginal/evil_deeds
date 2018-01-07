package ru.stqa.evil_deeds.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.evil_deeds.addressbook.model.GroupData;

import java.util.List;

public class GroupHelper extends HelperBase
{

    public GroupHelper(WebDriver wd)
    {
        super(wd);
    }

    public void submitGroupCreation()
    {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData)
    {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation()

    {
        click(By.name("new"));
    }

    public void returnToGroupPage()

    {
        click(By.linkText("groups"));
    }

    public void deleteSelectedGroups()

    {
        click(By.name("delete"));
    }

    public void selectGroup()
    {
        if (!wd.findElement(By.name("selected[]")).isSelected())
        {
            click(By.name("selected[]"));
        }
    }

    public void initGroupModification()
    {
        click(By.name("edit"));
    }

    public void submitGroupModification()
    {
        click(By.name("update"));
    }

    public void createGroup(GroupData groupData)
    {
        initGroupCreation();
        fillGroupForm(groupData);
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereAGroup()
    {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount()
    {
        return wd.findElements(By.cssSelector("span.group")).size();
    }
}

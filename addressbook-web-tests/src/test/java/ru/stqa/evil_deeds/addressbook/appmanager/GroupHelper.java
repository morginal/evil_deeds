package ru.stqa.evil_deeds.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.evil_deeds.addressbook.model.GroupData;

import java.util.ArrayList;
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

    public void selectGroup(int indexOfGroup)
    {
        wd.findElements(By.name("selected[]")).get(indexOfGroup).click();
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

    public List<GroupData> getGroupList()
    {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
//        List<WebElement> elements = wd.findElements(By.xpath("//span[@class='group']//input"));
        for(WebElement element : elements)
        {
            String name = element.getText();
            String id  = element.findElement(By.tagName("input")).getAttribute("value");
            GroupData group = new GroupData(id, name, null, null);
            groups.add(group);
        }
        return groups;
    }
}

package ru.stqa.evil_deeds.addressbook;

import org.testng.annotations.Test;

public class GroupDeletion extends TestBase
{
    @Test
    public void testGroupDeletion()
    {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage();
    }
}

package ru.stqa.evil_deeds.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase
{
    @Test
    public void testContactDeletion() throws Exception
    {
        app.getContactHelper().goContactPage();
        app.getContactHelper().deleteContact();
    }
}

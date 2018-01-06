package ru.stqa.evil_deeds.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.evil_deeds.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase
{
    @Test
    public void testContactDeletion() throws Exception
    {
        app.getContactHelper().goContactPage();

        if (! app.getContactHelper().isThereAContact())
        {
            app.getContactHelper().createContact(new ContactData(
                    "John",
                    "Constantine",
                    "89285555228",
                    "test@trashmail.me",
                    "test1"), true);
        }

        app.getContactHelper().deleteContact();
    }
}

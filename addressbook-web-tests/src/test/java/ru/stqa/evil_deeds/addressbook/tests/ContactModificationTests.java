package ru.stqa.evil_deeds.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.evil_deeds.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase
{
    @Test
    public void testContactModification()
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

        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactData(new ContactData(
                "Boris",
                "Bullet Dodger",
                "88005552555",
                "boris@seriousmail.me",
                null), false);
        app.getContactHelper().updateContactCard();
    }
}

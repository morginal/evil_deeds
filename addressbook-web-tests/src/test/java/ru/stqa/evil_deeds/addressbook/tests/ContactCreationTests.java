package ru.stqa.evil_deeds.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.evil_deeds.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase
{
    @Test
    public void newContactCreation() throws Exception
    {
        app.getContactHelper().initiateAddContact();
        app.getContactHelper().fillContactData(new ContactData("John", "Constantine", "89285555228", "test@trashmail.me"));
        app.getContactHelper().submitContactCard();
        app.getContactHelper().checkContactAdded();
    }
}

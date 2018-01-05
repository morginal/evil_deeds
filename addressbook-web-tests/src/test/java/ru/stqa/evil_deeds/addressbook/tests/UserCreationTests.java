package ru.stqa.evil_deeds.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.evil_deeds.addressbook.model.UserData;

public class UserCreationTests extends TestBase
{
    @Test
    public void newUserCreation() throws Exception
    {
        app.getUserHelper().initiateAddUser();
        app.getUserHelper().fillUserData(new UserData("John", "Constantine", "89285555228", "test@trashmail.me"));
        app.getUserHelper().submitUserCard();
        app.getUserHelper().checkUserAdded();
        app.getUserHelper().deleteUserRow();
    }
}

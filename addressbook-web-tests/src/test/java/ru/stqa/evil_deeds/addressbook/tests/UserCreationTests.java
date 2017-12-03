package ru.stqa.evil_deeds.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.evil_deeds.addressbook.model.UserData;

public class UserCreationTests extends TestBase
{
    @Test
    public void newUserCreation() throws Exception
    {
        app.initiateAddUser();
        app.fillUserData(new UserData("John", "Constantine", "89285555228", "test@trashmail.me"));
        app.submitUserCard();
        app.checkUserAdded();
        app.deleteUserRow();
    }
}

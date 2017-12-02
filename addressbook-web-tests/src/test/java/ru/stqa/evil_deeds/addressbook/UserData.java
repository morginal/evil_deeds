package ru.stqa.evil_deeds.addressbook;

public class UserData
{
    private final String username;
    private final String userLastname;
    private final String phone;
    private final String email;

    public UserData(String username, String userLastname, String phone, String email)
    {
        this.username = username;
        this.userLastname = userLastname;
        this.phone = phone;
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public String getUserLastname()
    {
        return userLastname;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }
}

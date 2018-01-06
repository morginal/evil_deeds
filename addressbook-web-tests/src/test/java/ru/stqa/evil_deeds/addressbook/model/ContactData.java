package ru.stqa.evil_deeds.addressbook.model;

public class ContactData
{
    private final String contactname;
    private final String contactLastname;
    private final String phone;
    private final String email;
    private String group;

    public ContactData(String contactname, String userLastname, String phone, String email, String group)
    {
        this.contactname = contactname;
        this.contactLastname = userLastname;
        this.phone = phone;
        this.email = email;
        this.group = group;
    }

    public String getContactname()
    {
        return contactname;
    }

    public String getContactLastname()
    {
        return contactLastname;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }

    public String getGroup()
    {
        return group;
    }
}

package ru.stqa.evil_deeds.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager
{
    FirefoxDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private UserHelper userHelper;

    public void init()
    {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("/opt/firefox_46.0.1/firefox/firefox"));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        userHelper = new UserHelper(wd);
        wd.get("http://localhost/addressbook/index.php");
        sessionHelper.login("admin", "secret");
    }

    public void stop()
    {
        wd.quit();
    }

    public GroupHelper getGroupHelper()
    {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper()
    {
        return navigationHelper;
    }

    public UserHelper getUserHelper()
    {
        return userHelper;
    }
}

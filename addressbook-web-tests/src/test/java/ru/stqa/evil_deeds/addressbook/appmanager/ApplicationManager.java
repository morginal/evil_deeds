package ru.stqa.evil_deeds.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager
{
    WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private UserHelper userHelper;
    private String browser;

    public ApplicationManager(String browser)
    {
        this.browser = browser;
    }

    public void init()
    {
        if (browser.equals(BrowserType.FIREFOX))
        {
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("/opt/firefox_46.0.1/firefox/firefox"));
        } else if (browser.equals(BrowserType.CHROME))
        {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE))
        {
            wd = new InternetExplorerDriver();
        }

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

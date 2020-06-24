package pages.homePage;

import Generic.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.contactPage.ContactsPage;
import pages.dealPage.DealsPage;
import pages.tasksPage.TasksPage;

public class HomePage extends Base {
    @FindBy(xpath = "//span[text()='massi sako']")
    @CacheLookup
    WebElement userNameLabel;

    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    WebElement tasksLink;
    @FindBy(xpath = "//a//button[@class='ui linkedin button']")
    WebElement newContactButton;



    // Initializing the Page Objects:
    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    public String verifyHomePageTitle() {
        return driver.getTitle();
    }
    public boolean verifyCorrectUserName() {
        return userNameLabel.isDisplayed();
    }
    public ContactsPage clickOnContactsLink() {
        contactsLink.click();
        return new ContactsPage();
    }
    public DealsPage clickOnDealsLink() {
        dealsLink.click();
        return new DealsPage();
    }
    public TasksPage clickOnTasksLink() {
        tasksLink.click();
        return new TasksPage();
    }
    public void clickOnNewContactLink() {
        newContactButton.click();

    }


}

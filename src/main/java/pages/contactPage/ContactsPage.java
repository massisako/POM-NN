package pages.contactPage;

import Generic.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends Base {


    @FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
    WebElement contactsLabel;

    @FindBy(xpath = "//a//button[@class='ui linkedin button']")
    WebElement newContactButton;
    @FindBy(name = "first_name")
    WebElement nameField;
    @FindBy(name = "last_name")
    WebElement lastNameField;
//    @FindBy (name = "channel_type")
//    WebElement channelType;

    public ContactsPage(){
        PageFactory.initElements(driver,this);
    }

    public Boolean verifyContactsLabel(){
        return  contactsLabel.isDisplayed();

    }
    public void selectContacts(String name){
        driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]")).click();
    }
    public void addNewContact(String name, String lastName){
//        newContactButton.click();
//        driver.navigate().refresh();
//        driver.navigate().refresh();
        nameField.sendKeys(name);
        lastNameField.sendKeys(lastName);
//        Select countrySelect = new Select(channelType);
//        countrySelect.selectByVisibleText("Facebook");

    }
}

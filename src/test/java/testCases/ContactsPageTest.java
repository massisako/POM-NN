package testCases;

import Generic.Base;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.contactPage.ContactsPage;
import pages.homePage.HomePage;
import pages.loginPage.LoginPage;
import util.TestUtil;

public class ContactsPageTest extends Base {

    LoginPage loginPage;
    ContactsPage contactsPage;
    HomePage homePage;

    String sheetName = "contacts";

    public ContactsPageTest(){
        super();
    }

    @BeforeMethod
    public void seUp(){
        initialization();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("emailAddressField"), prop.getProperty("password"));
        contactsPage = homePage.clickOnContactsLink();
    }
    @Test
    public void verifyContactsPageLabel(){
        Assert.assertTrue(contactsPage.verifyContactsLabel());
    }
    @Test
    public void selectSingleContactsTest() {
        driver.navigate().refresh();
        contactsPage.selectContacts("mezian bena");
    }
    @Test
    public void selectMultiplesContactsTest() {
        driver.navigate().refresh();
        contactsPage.selectContacts("someone somthing");
        contactsPage.selectContacts("massi sako");
        contactsPage.selectContacts("mezian bena");
    }

    @DataProvider
    public Object[][] getCRMTestData() throws InvalidFormatException {
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test( dataProvider = "getCRMTestData")
    public void addNewContactTest(String name, String lastName) throws InterruptedException {
        homePage.clickOnNewContactLink();
        driver.navigate().refresh();
        driver.navigate().refresh();
        contactsPage.addNewContact(name,lastName);
        Thread.sleep(2000);
    }
    @AfterMethod
    public  void browserClose(){
        driver.quit();
    }


}

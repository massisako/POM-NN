package testCases;

import Generic.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.contactPage.ContactsPage;
import pages.homePage.HomePage;
import pages.loginPage.LoginPage;
import pages.contactPage.ContactsPage;
public class HomePageTest extends Base {

    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setUpHomePage() {
        initialization();
        loginPage = new LoginPage();
        homePage= loginPage.login(prop.getProperty("emailAddressField"), prop.getProperty("password"));
       // contactsPage = new ContactsPage();
    }
    @Test
    public void HomePageTitleTest()  {
      //  loginPage.login(prop.getProperty("emailAddressField"), prop.getProperty("password")); //this is better on the before method because you need so you will lend on the
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "Cogmento CRM","home page title is not correct");//the 3rd string is optional.
    }
    @Test
    public void verifyNameTest(){
        Assert.assertTrue(homePage.verifyCorrectUserName());

    }
    @Test
    public void verifyContactsLinkTest(){
        contactsPage = homePage.clickOnContactsLink();

    }




    @AfterMethod
    public void closingBrowser(){
        driver.quit();
    }
}
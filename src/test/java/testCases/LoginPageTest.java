package testCases;

import Generic.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.homePage.HomePage;
import pages.loginPage.LoginPage;

public class LoginPageTest extends Base {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();

    }
    @Test(priority=1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
    }

    @Test(priority=2)
    public void crmLogoImageTest(){
        boolean flag = loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }

    @Test(priority=3)
    public void loginTest() throws InterruptedException {
        homePage = loginPage.login(prop.getProperty("emailAddressField"), prop.getProperty("password"));
    }


//    @Test()
//    public void checkSelectDate(){
//        loginPage.selectDate();
//    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




}

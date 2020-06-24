package pages.loginPage;

import Generic.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.homePage.HomePage;

public class LoginPage extends Base {

    @FindBy(xpath = "//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
    WebElement firstLoginBTN;

    @FindBy(xpath="//input[@placeholder='E-mail address']")
    WebElement emailAddressField;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    WebElement secondLoginBTN;

    @FindBy(xpath = "//div[@class='rd-navbar-panel']//a[@class='brand-name']")
    WebElement crmLogo;




//    @FindBy(xpath = "//div[@class='_1v09r7q']//div[1]//button[1]")
//    WebElement  checkIn;
//
//    public void selectDate(){
//        checkIn.click();
//    }


    //Initializing the Page Objects:
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    //Actions:
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
    public boolean validateCRMImage () {
        return crmLogo.isDisplayed();
    }
    public HomePage login(String email, String pwd)  {
        firstLoginBTN.click();
        emailAddressField.sendKeys(email);
        password.sendKeys(pwd);
        secondLoginBTN.click();
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click();", loginBtn);

        return new HomePage();


   }
}

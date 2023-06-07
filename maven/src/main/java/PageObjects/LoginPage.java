package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void openLoginPage() {
        this.driver.get("http://xthb.huce.edu.vn/Home/Login?ReturnUrl=%2f");
        this.driver.manage().window().fullscreen();
    }

    @FindBy(xpath = "//input[@id='txt_acc']")
    public WebElement txtAccount;

    @FindBy(xpath = "//input[@id='txt_pass']")
    public WebElement txtPwd;

    @FindBy(xpath = "//button[@id='btn-login']")
    public WebElement btnLogin;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement msgToastMsg;
    @FindBy(xpath = "//div[@class='toast-message' and text()= 'Vui lòng  n123123hập vào mật khẩu']")
    public WebElement msgToastMsgWait;


    public void setMsgToastMsg(WebElement msgToastMsg) {
        this.msgToastMsg = msgToastMsg;
    }
}

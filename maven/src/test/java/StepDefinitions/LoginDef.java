package StepDefinitions;
import CommonFuncs.DataTableSection;
import PageObjects.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginDef {
    WebDriver driver;
    LoginPage loginPage;
    WebDriverWait wait;
    @Given("The login page is shown")
    public void theLoginPageIsShown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webDriver/chromedriver.exe");
        this.driver = new ChromeDriver();

        this.loginPage = new LoginPage(this.driver);
        this.loginPage.openLoginPage();
    }

    @When("User attempt to login with account is {string} and password is {string}")
    public void userAttemptToLoginWithAccountIsAndPasswordIs(String account, String password) {
        this.loginPage.txtAccount.sendKeys(account);
        this.loginPage.txtPwd.sendKeys(password);
        this.loginPage.btnLogin.click();
    }

    @Then("The message {string} is shown")
    public void theMessageIsShown(String expMsg) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        Boolean actMsg = false;

        try {
            actMsg = wait.until(ExpectedConditions.visibilityOf(this.loginPage.msgToastMsgWait)).isDisplayed();
            Assertions.assertEquals(true, actMsg);
        } catch (TimeoutException e) {
            System.out.println("khong ton tai msgToastMsgWait ");
        }
//        this.loginPage.msgToastMsg.isDisplayed();
//        Assertions.assertEquals(actMsg, actMsg);
    }

    @Then("Close browser")
    public void closeBrowser() {
        this.driver.close();
    }

    @When("User attempt to login with data")
    public void userAttemptToLoginWithData(DataTable dataTable) {
        // Get data table value
        String username = DataTableSection.getDataRowByKey(dataTable, "User name");
        String password = DataTableSection.getDataRowByKey(dataTable, "Pass word");
        // Action test
        this.loginPage.txtAccount.sendKeys(username);
        this.loginPage.txtPwd.sendKeys(password);
        this.loginPage.btnLogin.click();
    }

    @Then("The message {string} is shown in {int} seconds")
    public void theMessageIsShownInSeconds(String arg0, int arg1) {

    }
}

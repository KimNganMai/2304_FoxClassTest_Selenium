package StepDefinitions;
import CommonFuncs.DataTableSection;
import PageObjects.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDef {
    WebDriver driver;
    LoginPage loginPage;

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
        String actMsg = this.loginPage.msgToastMsg.getText().toString();
        this.loginPage.msgToastMsg.isDisplayed();
        Assertions.assertEquals(expMsg, actMsg);
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
}

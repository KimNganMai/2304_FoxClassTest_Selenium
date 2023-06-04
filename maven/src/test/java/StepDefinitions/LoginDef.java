package StepDefinitions;
import PageObjects.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

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
        String actMsg = this.loginPage.msgToastMsg.getText();
        Assertions.assertEquals(expMsg, actMsg);
    }

    @Then("Close browser")
    public void closeBrowser() {
        this.driver.close();
    }

    @When("User attempt to login with data")
    public void userAttemptToLoginWithData(DataTable datatable) {
        for (Map<String, String> row : datatable.asMaps(String.class, String.class)) {
            System.out.println(row.get("User name"));
        }
    }
}

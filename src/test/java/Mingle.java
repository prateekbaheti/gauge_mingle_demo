import com.thoughtworks.gauge.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Mingle {

    WebDriver browser;

    @Step("Sign me in with name <username> and password <password>")
    public void signIn(String username, String password) {
        browser.get("https://ankit.mingle.thoughtworks.com/");
        browser.findElement(By.id("user_login")).sendKeys(username);
        browser.findElement(By.id("user_password")).sendKeys(password);
        browser.findElement(By.name("commit")).click();
    }

    @Step("To create a new project, click the New project link on the Current projects page.")
    public void createNewProject() {
    }

    @Step("When entering project details, choose the template you want to use as a basis for your project.")
    public void chooseTemplate() {
    }

    @Step("Click the <link_name> link to complete project creation.")
    public void completeProjectCreation(String linkName) {
    }

    @Step("Enter project name <project_name> and select the <option>.")
    public void enterProjectName(String projectName, String option) {
    }

    @BeforeSuite
    public void initializeDriver(){
        browser = new FirefoxDriver();
    }

    @AfterSuite
    public void tearDown(){
        if (browser != null) {
            browser.close();
        }
    }

    @AfterScenario
    public void signOut() {
        browser.findElement(By.id("logout")).click();
    }

}


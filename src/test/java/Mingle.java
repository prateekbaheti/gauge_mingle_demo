import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.UUID;

public class Mingle {

    WebDriver browser;

    @Step("Sign in with name <username> and password <password>")
    public void signIn(String username, String password) {
        browser.get("https://ankit.mingle.thoughtworks.com/");
        browser.findElement(By.id("user_login")).sendKeys(username);
        browser.findElement(By.id("user_password")).sendKeys(password);
        browser.findElement(By.name("commit")).click();
    }

    @Step("To create a new project, click the New project link on the Current projects page.")
    public void createNewProject() throws InterruptedException {
        if (!browser.getCurrentUrl().equals("https://ankit.mingle.thoughtworks.com")) {
            browser.get("https://ankit.mingle.thoughtworks.com/");
        }
        browser.findElement(By.linkText("NEW PROJECT")).click();
    }

    @Step("When entering project details, choose the template <name>.")
    public void chooseTemplate(String name) {
        browser.findElement(By.id("project_name")).sendKeys("Project with template " + UUID.randomUUID().toString().subSequence(0, 7));
        browser.findElement(By.xpath("//*[@id=\"template-list\"]/div[1]/div[1]/div[1]/label/img")).click();
    }

    @Step("Click the <link_name> link to complete project creation.")
    public void completeProjectCreation(String linkName) throws InterruptedException {
        browser.findElement(By.id("create_project")).click();
    }

    @Step("Enter project name <project_name> and select blank template.")
    public void enterProjectName(String projectName) {
        browser.findElement(By.id("project_name")).sendKeys("Project without template " + UUID.randomUUID().toString().subSequence(0, 7));
    }

    @BeforeSuite
    public void initializeDriver() {
        browser = new FirefoxDriver();
    }

    @AfterSuite
    public void tearDown() {
        if (browser != null) {
            browser.close();
        }
    }

    @AfterScenario
    public void logout() {
        browser.findElement(By.id("logout")).click();
    }

}



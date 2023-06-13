package Register;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import java.time.Duration;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.testng.Assert.assertEquals;


public class MyStepdefs {


    private WebDriver driver;


    public MyStepdefs() {
    }

    @Given("Open the website login page")
    public void setup() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        this.driver = new FirefoxDriver();
        //driver.manage().window().setSize(new Dimension(1520, 830));
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1500, 1000));

        this.driver.get("https://codenboxautomationlab.com/registration-form/");
        Thread.sleep(5000);
    }

    @When("Enter First Name which must start with capital letter")
    public void the_first_name_is_entered_correctly() throws InterruptedException {
        WebElement firstName = this.driver.findElement(By.cssSelector("#nf-field-17"));
        firstName.sendKeys("Sarah");
    }

    @And("The first name is entered correctly")
    public void theFirstNameIsEnteredCorrectly() throws InterruptedException {
        WebElement firstName = this.driver.findElement(By.cssSelector("#nf-field-17"));
        String enteredFirstName = firstName.getAttribute("value");
        boolean startsWithCapitalLetter = Character.isUpperCase(enteredFirstName.charAt(0));
        Assert.assertTrue(startsWithCapitalLetter, "First name should start with a capital letter");
        Thread.sleep(2000);
    }

    @And("Enter Last Name which must start with capital letter and can’t be equal First Name")
    public void enterLastNameWhichMustStartWithCapitalLetterAndCanTBeEqualFirstName() throws InterruptedException, IOException {
        WebElement lastNameField = this.driver.findElement(By.cssSelector("#nf-field-18"));
        lastNameField.sendKeys("Ahmed");
        Thread.sleep(2000);
    }

    @And("The last name is entered correctly")
    public void theLastNameIsEnteredCorrectly() {
        WebElement lastNameField = this.driver.findElement(By.cssSelector("#nf-field-18"));
        String enteredLastName = lastNameField.getAttribute("value");
        boolean startsWithCapitalLetter = Character.isUpperCase(enteredLastName.charAt(0));
        Assert.assertTrue(startsWithCapitalLetter, "Last name should start with a capital letter");
    }


    private String email;

    @And("I enter a unique email address")
    public void iEnterUniqueEmailAddress() {
        // Generate a unique email address
        email = generateUniqueEmailAddress();

        // Enter the email address in the input field
        driver.findElement(By.cssSelector("#nf-field-19")).sendKeys(email);
    }

    private String generateUniqueEmailAddress() {
        // Generate a unique email address
        String uniqueId = UUID.randomUUID().toString();
        return "unique_email_" + uniqueId + "@example.com";
    }


    @And("Enter a valid Mobile Number")
    public void enterAValidMobileNumber() throws InterruptedException {
        Thread.sleep(2000);
        WebElement mobileNumberField = this.driver.findElement(By.cssSelector("#nf-field-20"));
        mobileNumberField.sendKeys("01558308233");

        String enteredMobileNumber = mobileNumberField.getAttribute("value");
        assertEquals(enteredMobileNumber, "01558308233");
        Thread.sleep(2000);



    }





    @And("Select from dropdown list a course")
    public void Selectfromdropdownlistacourse() {

        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"nf-field-22\"]"));
        Select dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();

        Random random = new Random();
        int index = random.nextInt(options.size());

        for (int i = 0; i < options.size(); i++) {
            if (i == index) {
                dropdown.selectByIndex(i);
                break;
            }
        }

    }

    @And("Select from dropdown list a Batch")
    public void SelectfromdropdownlistaBatch() {

        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"nf-field-24\"]"));
        Select dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();

        Random random = new Random();
        int index = random.nextInt(options.size());

        for (int i = 0; i < options.size(); i++) {
            if (i == index) {
                dropdown.selectByIndex(i);
                break;
            }
        }

    }

    @And("Select from Checkdown list")
    public void Selectfromcheckdownlist() throws IOException {

        WebElement CheckListElement = driver.findElement(By.xpath("//*[@id=\"nf-label-class-field-23-1\"]"));
        CheckListElement.click();

        WebElement section = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/main/article/div/div[1]/div/div[4]/form/div/div[2]"));
        File src= section.getScreenshotAs(OutputType.FILE);
        File file=new File("C:\\Users\\hoss\\Desktop\\project automation testoligic\\FWD\\GetGroupTask\\Users\\Acer\\Downloads\\untitled\\screenshots\\Img1.png");
        FileUtils.copyFile(src , file);

    }

    @And("Click on Register button")
    public void ClickonRegisterbutton() throws InterruptedException {

        WebElement  Registerbutton = driver.findElement(By.xpath("//*[@id=\"nf-field-15\"]"));
        Registerbutton.click();
        Thread.sleep(5000);


    }


    @Then("I should see {string} on the page")
    public void i_should_see_on_the_page(String text) throws InterruptedException {

        Thread.sleep(5000);

        WebElement element = driver.findElement(By.className("nf-response-msg"));
        String elementText = element.getText();

        System.out.println(elementText);
        assertEquals(elementText, "Your registration is completed. We will contact with you soon. Thank you !");

    }



    @Then("I take a screenshot")
    public void iTakeAScreenshot() throws IOException {


        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path destination = Path.of("C:\\Users\\hoss\\Desktop\\project automation testoligic\\FWD\\GetGroupTask\\Screenshots", "screenshot3.png");
        try {
            Files.createDirectories(destination.getParent());
            Files.copy(screenshot.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}






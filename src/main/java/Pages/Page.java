package Pages;

import Base.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Page extends Driver {
    //declaring variable
    public String searchText = "ch";

    public void defaultLogin() {
        //adding username and password in fields
        WebElement txtBoxUserName = driver.findElement(By.id("app")).findElement(By.name("username"));
        txtBoxUserName.sendKeys("Admin");
        WebElement txtBoxPwd = driver.findElement(By.id("app")).findElement(By.name("password"));
        txtBoxPwd.sendKeys("admin123");

        //click submit button
        WebElement btnLogin = driver.findElement(By.id("app")).findElement(By.xpath("//button[@type='submit']"));
        btnLogin.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
        }
    }

    //go to PIM page
    public void goPIM() {
        //click on PIM menu
        WebElement menuPIM = driver.findElement(By.id("app"))
                .findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));
        menuPIM.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
        }
    }

    //search user with partial text
    public void searchPIM() {
        //type in Employee Name textbox
        WebElement txtBoxEmName = driver.findElement(By.id("app")).findElement(By.cssSelector("[placeholder='Type for hints...']"));
        txtBoxEmName.sendKeys(searchText);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
        }
    }

    //search records
    public void search() {
        //click on Search-button
        WebElement btnSearch = driver.findElement(By.xpath("//button[@type='submit']"));
        btnSearch.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
        }
    }

    //go to Admin page
    public void goAdmin() {
        //click on Admin menu
        WebElement menuAdmin = driver.findElement(By.id("app"))
                .findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']"));
        menuAdmin.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
        }
    }

    //Open Job dropdown and go to PayGrade
    public void go_job_to_PayGrade() {
        //click on Job tab
        WebElement tabJob = driver.findElement(By.id("app")).findElements(By.className("oxd-topbar-body-nav-tab-item")).get(1);
        tabJob.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
        }
        //click on Pay Grade menu
        WebElement menuPayGrade = driver.findElement(By.id("app")).findElement(By.linkText("Pay Grades"));
        menuPayGrade.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
    }

    //add Pay Grade
    public void addPayGrade() {
        //click on Add button
        WebElement btnAdd = driver.findElement(By.id("app"))
                .findElement(By.className("orangehrm-header-container"))
                .findElement(By.className("oxd-button"));
        btnAdd.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        //add name in input
        WebElement txtBoxName = driver.findElement(By.id("app"))
                .findElement(By.className("oxd-form-row"))
                .findElement(By.className("oxd-input"));
        txtBoxName.sendKeys("Indian Rupee");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
        }
        //save input
        WebElement btnSaveCur = driver.findElement(By.id("app"))
                .findElement(By.className("orangehrm-card-container"))
                .findElement(By.className("oxd-form-actions"))
                .findElement(By.cssSelector("button[type='submit']"));
        btnSaveCur.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }
        System.out.println("Rupee Submitted");
    }

    //addCurrency
    public void addCurrency() {
        Actions actions = new Actions(driver);
        //click Add Currency button
        WebElement btnAddCurrency = driver.findElement(By.id("app"))
                .findElement(By.className("orangehrm-paper-container"))
                .findElement(By.className("oxd-button"));
        btnAddCurrency.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        //open Currency dropdown
        WebElement inputCurrencyDropdown = driver.findElement(By.id("app"))
                .findElement(By.className("oxd-select-text-input"));
        inputCurrencyDropdown.click();
        //select Indian currency
        actions.sendKeys("i");
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER).build().perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
        }
        System.out.print(inputCurrencyDropdown.getText());
        //add minimum and maximum salaries
        WebElement txtBoxMinSal = driver.findElement(By.id("app"))
                .findElements(By.className("oxd-grid-item")).get(2)
                .findElement(By.className("oxd-input"));
        txtBoxMinSal.sendKeys("30000");
        WebElement txtBoxMaxSal = driver.findElement(By.id("app"))
                .findElements(By.className("oxd-grid-item")).get(3)
                .findElement(By.className("oxd-input"));
        txtBoxMaxSal.sendKeys("100000");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        WebElement btnSaveSal = driver.findElement(By.id("app"))
                .findElements(By.cssSelector("button[type='submit']")).get(1);
        btnSaveSal.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }
    }

    public void close() {
        driver.close();
        driver.quit();
    }

}

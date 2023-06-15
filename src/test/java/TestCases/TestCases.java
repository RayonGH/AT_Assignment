package TestCases;

import Pages.Page;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;
import org.openqa.selenium.By;

public class TestCases extends Page {

    private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    //TEST
    @Test
    public void TestCase_SearchUserWithPartialTextMatch() {
        try {
            //open Chrome
            setUpBrowser("Chrome");
            //opening URL
            driver.get(url);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
            }
            //login page
            defaultLogin();
            //go to PIM page
            goPIM();
            //search user with partial text
            searchPIM();
            //getting matched results of autocomplete dropdown list
            List<WebElement> dropDownList_Chrome = driver.findElement(By.id("app")).findElements(By.className("oxd-autocomplete-dropdown"));
            String item_Chrome;
            //checking each list item contains searched text
            for (WebElement listItem : dropDownList_Chrome) {
                item_Chrome = listItem.getText().toLowerCase();
                Assert.assertTrue(item_Chrome.contains(searchText), item_Chrome);
            }
            //click on search button
            search();
            //check at least the first 3 should have searched text in either First or Last name
            //get searched records
            String firstName_Chrome = null, lastName_Chrome = null;
            List<WebElement> first3Rows_Chrome = driver.findElement(By.id("app"))
                    .findElement(By.className("orangehrm-employee-list"))
                    .findElement(By.className("oxd-table-body"))
                    .findElements(By.className("oxd-table-row"))
                    .subList(0, 3);
            for (WebElement row_Chrome : first3Rows_Chrome) {
                List<WebElement> tableCells_Chrome = row_Chrome.findElements(By.className("oxd-table-cell")).subList(2, 4);
                firstName_Chrome = tableCells_Chrome.get(0).getText().toLowerCase();
                lastName_Chrome = tableCells_Chrome.get(1).getText().toLowerCase();
                Assert.assertTrue(firstName_Chrome.contains("ch") || lastName_Chrome.contains("ch"));
            }
        } finally {
            //close the browser
            close();
        }
    }

    @Test
    public void TestCase_VerifyUserCanAddPayGrades() {
        try {
            //open Chrome
            setUpBrowser("Chrome");
            //opening URL
            driver.get(url);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
            }
            //login page
            defaultLogin();
            //go to Admin page
            goAdmin();
            //Open Job dropdown and go PayGrade
            go_job_to_PayGrade();
            //add Pay Grade
            addPayGrade();
            //add and save currency and salary
            addCurrency();
            //check 'Record Found' text is shown
            WebElement txtRecord = driver.findElement(By.id("app"))
                    .findElement(By.className("orangehrm-horizontal-padding"))
                    .findElement(By.className("oxd-text"));
            System.out.println(txtRecord.getText());
            Assert.assertEquals(txtRecord.getText(), "(1) Record Found");
            //check values of saved currency, min sal and max sal
            WebElement txtCurrency = driver.findElement(By.id("app"))
                    .findElement(By.className("orangehrm-container"))
                    .findElements(By.className("oxd-table-cell")).get(1);
            System.out.println(txtCurrency.getText());
            Assert.assertEquals(txtCurrency.getText(), "Indian Rupee");
            WebElement txtMinSal = driver.findElement(By.id("app"))
                    .findElement(By.className("orangehrm-container"))
                    .findElements(By.className("oxd-table-cell")).get(2);
            System.out.println(txtMinSal.getText());
            Assert.assertEquals(txtMinSal.getText(), "30000.00");
            WebElement txtMaxSal = driver.findElement(By.id("app"))
                    .findElement(By.className("orangehrm-container"))
                    .findElements(By.className("oxd-table-cell")).get(3);
            System.out.println(txtMaxSal.getText());
            Assert.assertEquals(txtMaxSal.getText(), "100000.00");
        } finally {
            //close the browser
            close();
        }
    }
}

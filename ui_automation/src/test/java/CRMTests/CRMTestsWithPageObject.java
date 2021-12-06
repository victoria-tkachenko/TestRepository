package CRMTests;


import CRM.pages.*;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;


@Feature("Тестирование CRM c cookie")
public class CRMTestsWithPageObject extends BaseTestLoginWithCookie {

    @Test
    void createNewProjectTest() throws InterruptedException {
        new MainPage(driver).openMyProjectsPage();
        new MyProjectsPage(driver).setCreateProject();
        new CreateProjectPage(driver).fillProjectName("Pr23")
                .fillOrganization("1234")
                .selectBusinessUnit("Research & Development")
                .selectCurator("Applanatest Applanatest Applanatest")
                .selectProjectLeader("Applanatest1 Applanatest1 Applanatest1")
                .selectProjectManager("Амелин Владимир")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new CreateProjectPage(driver).requestSuccessLocator)));

        assertThat(new CreateProjectPage(driver).requestSuccess, isDisplayed());
    }

    @Test
    void createContactPerson() throws InterruptedException {

        new MainPage(driver).openAllContactPersonsPage();
        new AllContactPersonsPage(driver).setCreateContactPerson();
        new CreateContactPersonPage(driver)
                .fillLastName("Петров")
                .fillFirstName("Петр")
                .fillOrganization("1234")
                .fillJobTitle("специалист")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new CreateContactPersonPage(driver).requestSuccessLocator)));

        assertThat(new CreateContactPersonPage(driver).requestSuccess, isDisplayed());
    }


    @Test
    void createNewExpenseRequest() {
        new LoginPage(driver).login("Applanatest1", "Student2020!")
                .navigationMenu.openNavigationMenuItem("Расходы");

        new ExpensesSubMenu(driver).createExpense();
        new ExpenseRequestsPage(driver).createExpense();

        new CreateExpenseRequestPage(driver)
                .fillDescription("test")
                .selectBusinessUnit("Research & Development")
                .selectExpense("01101 - ОС: вычислительная техника инфраструктуры")
                .fillSumPlan("123")
                .selectDate("24")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new CreateExpenseRequestPage(driver).requestSuccessLocator)));

        assertThat(new CreateExpenseRequestPage(driver).requestSuccess,
                isDisplayed());
    }
}

package CRMTests;

import CRM.pages.LoginPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import static CRM.pages.Configuration.BASE_URL;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Feature("Тестирование создания заявки на расход")
public class LoginWithPageObjectTest extends BaseTest{

    @BeforeAll
    public void goToPage() {

        driver.get(BASE_URL);
    }

    @Test
    void loginTestWithFluentPage() {
        new LoginPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .submitLogin();
    }
}

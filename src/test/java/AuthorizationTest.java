import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.AuthPage;
import pageobject.ForgotPasswordPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;
import usermodel.GenerateUser;
import usermodel.User;

public class AuthorizationTest {
    RegistrationPage registrationPage = new RegistrationPage();
    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    User user;

    @Before
    public void setUp() {
        user = GenerateUser.getRandom(6);
        registrationPage.openPage();
        registrationPage.register(user.getName(), user.getEmail(), user.getPassword());
    }

    @After
    public void clearBrowser() {
        authPage.logOut();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void shouldAuthWithButtonAuthInAccount() {
        mainPage.openPage();
        mainPage.buttonAuthInAccountClick();
        authPage.auth(user.getEmail(), user.getPassword())
                .checkAuthSuccess(user.getName(), user.getEmail());
    }

    @Test
    public void shouldAuthWithButtonPersonalAccount() {
        mainPage.openPage();
        mainPage.buttonPersonalAccountClick();
        authPage.auth(user.getEmail(), user.getPassword())
                .checkAuthSuccess(user.getName(), user.getEmail());
    }

    @Test
    public void shouldAuthWithButtonRegisterPage() {
        registrationPage.openPage().buttonAuthClick();
        authPage.auth(user.getEmail(), user.getPassword())
                .checkAuthSuccess(user.getName(), user.getEmail());
    }

    @Test
    public void shouldAuthWithButtonForgotPassword() {
        forgotPasswordPage.openPage().buttonAuthClick();
        authPage.auth(user.getEmail(), user.getPassword())
                .checkAuthSuccess(user.getName(), user.getEmail());
    }
}

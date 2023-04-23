import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Test;
import pageobject.AuthPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;
import usermodel.GenerateUser;
import usermodel.User;

public class LogOutTest {
    MainPage mainPage = new MainPage();
    RegistrationPage registrationPage = new RegistrationPage();
    AuthPage authPage = new AuthPage();

    User user;
    @After
    public void clearBrowser() {
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void shouldLogOut() {
        user = GenerateUser.getRandom(6);
        registrationPage.openPage()
                .register(user.getName(), user.getEmail(), user.getPassword());
        authPage.auth(user.getEmail(), user.getPassword());
        mainPage.checkUserLogOut();
    }
}

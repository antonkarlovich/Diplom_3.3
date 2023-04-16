import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Test;
import pageobject.AuthPage;
import pageobject.RegistrationPage;
import usermodel.GenerateUser;
import usermodel.User;

public class RegistrationTest {
    private static final String INVALID_PASSWORD = "Некорректный пароль";
    RegistrationPage registerPage = new RegistrationPage();
    AuthPage authPage = new AuthPage();

    User user;
    @After
    public void clearBrowser() {
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void checkRegister() {
        user = GenerateUser.getRandom(6);
        registerPage.openPage();
        registerPage.register(user.getName(), user.getEmail(), user.getPassword());
        authPage.openPage();
        authPage.auth(user.getEmail(), user.getPassword());

        authPage.checkAuthSuccess(user.getName(), user.getEmail());

        authPage.logOut();
    }

    @Test
    public void checkRegisterShortPassword() {
        user = GenerateUser.getRandom(5);
        registerPage.openPage();
        registerPage.register(user.getName(), user.getEmail(), user.getPassword());

        registerPage.checkTextError(INVALID_PASSWORD)
                .checkPage();
    }

}

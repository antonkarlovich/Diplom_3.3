import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Test;
import pageobject.AuthPage;
import pageobject.MainPage;
import pageobject.PersonalAccountPage;
import pageobject.RegistrationPage;
import usermodel.GenerateUser;
import usermodel.User;

public class MoveToPageTest {

    MainPage mainPage = new MainPage();
    AuthPage authPage = new AuthPage();
    RegistrationPage registrationPage = new RegistrationPage();
    PersonalAccountPage personalAccountPage = new PersonalAccountPage();
    User user;


    @After
    public void clearBrowser() {
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void moveToPersonalAccount() {
        User user = GenerateUser.getRandom(6);
        registrationPage.openPage().register(user.getName(), user.getEmail(), user.getPassword());
        authPage.openPage()
                .auth(user.getEmail(), user.getPassword());
        mainPage.buttonPersonalAccountClick();
        personalAccountPage.checkTextProfile();
    }

    @Test
    public void moveToStellarBurger() {
        mainPage.openPage()
                .buttonPersonalAccountClick()
                .stellarBurgersClick()
                .checkTextCollectToBurger();
    }

    @Test
    public void moveToConstructor() {
        mainPage.openPage()
                .buttonPersonalAccountClick()
                .constructorClick()
                .checkTextCollectToBurger();
    }
}

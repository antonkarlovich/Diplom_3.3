package pageobject;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


import com.codeborne.selenide.SelenideElement;
public class AuthPage {
    private static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    MainPage mainPage = new MainPage();
    PersonalAccountPage personalAccountPage = new PersonalAccountPage();
    private final SelenideElement inputEmail = $x("//input[@name='name']");
    private final SelenideElement inputPassword = $x("//input[@name='Пароль']");
    private final SelenideElement buttonAuth = $x(".//button[text()='Войти']");
    private final SelenideElement textEnter = $x(".//h2[text()='Вход']");

    public AuthPage openPage() {
            open(LOGIN_URL);
        return this;
    }

    public AuthPage buttonAuthClick() {
        buttonAuth.click();
        return this;
    }

    public AuthPage inputEmail(String email) {
        inputEmail.setValue(email);
        return this;
    }

    public AuthPage inputPassword(String password) {
        inputPassword.setValue(password);
        return this;
    }


    public AuthPage auth(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        buttonAuthClick();
        return this;
    }

    public AuthPage checkAuthSuccess(String name, String email) {
        mainPage.buttonPersonalAccountClick();
        personalAccountPage.checkName(name)
                .checkEmail(email);
        return this;
    }

    public AuthPage logOut() {
        personalAccountPage.buttonLogOutClick();
        return this;
    }

    public AuthPage shouldBeTextLogin() {
        textEnter.shouldHave(text("Вход"));
        return this;
    }
}

package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private static final String REGISTRATION_URL = "https://stellarburgers.nomoreparties.site/register";
    private final SelenideElement inputName = $x("//fieldset[1]//input");
    private final SelenideElement inputEmail = $x("//fieldset[2]//input");
    private final SelenideElement inputPassword = $x("//fieldset[3]//input");
    private final SelenideElement buttonRegister = $x(".//button[text()='Зарегистрироваться']");
    private final SelenideElement buttonAuth = $x(".//a[text()='Войти']");

    private final SelenideElement errorPasswordText = $x("//fieldset[3]//p");

    public RegistrationPage openPage() {
        open(REGISTRATION_URL);

        return this;
    }
    public RegistrationPage buttonRegisterClick() {
        buttonRegister.click();
        return this;
    }
    public RegistrationPage buttonAuthClick() {
        buttonAuth.click();
        return this;
    }
    public RegistrationPage inputName(String name) {
        inputName.setValue(name);
        return this;
    }
    public RegistrationPage inputEmail(String email) {
        inputEmail.setValue(email);
        return this;
    }
    public RegistrationPage inputPassword(String password) {
        inputPassword.setValue(password);
        return this;
    }
    public RegistrationPage checkTextError(String error) {
        errorPasswordText.shouldHave(text(error));
        return this;
    }
    public RegistrationPage checkPage() {
        buttonRegister.should(Condition.visible);
        return this;
    }

    public RegistrationPage register(String name, String email, String password) {
        inputName(name);
        inputEmail(email);
        inputPassword(password);
        buttonRegisterClick();
        return this;
    }
}

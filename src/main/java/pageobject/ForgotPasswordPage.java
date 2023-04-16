package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ForgotPasswordPage {

    private static final String FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private final SelenideElement buttonAuthInAccount = $x(".//a[text()='Войти']");

    public ForgotPasswordPage openPage() {
        open(FORGOT_PASSWORD_URL);
        return this;
    }
    public ForgotPasswordPage buttonAuthClick() {
        buttonAuthInAccount.click();
        return this;
    }
}

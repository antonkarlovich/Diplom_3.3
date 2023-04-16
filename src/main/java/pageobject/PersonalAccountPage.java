package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import org.junit.Assert;

public class PersonalAccountPage {

    private static final String PERSONAL_ACCOUNT = "https://stellarburgers.nomoreparties.site/account/profile";
    private final SelenideElement labelName = $x("//li[@class='Profile_profileListItem__2th0t mb-6'][1]//input");
    private final SelenideElement labelLogin = $x("//li[@class='Profile_profileListItem__2th0t mb-6'][2]//input");

    private final SelenideElement buttonLogOut = $x("//li[@class='Account_listItem__35dAP'][3]//button");

    private final SelenideElement headForm = $(byText("Профиль"));


    public PersonalAccountPage openPage() {
        open(PERSONAL_ACCOUNT);
        return this;
    }

    public PersonalAccountPage buttonLogOutClick() {
        buttonLogOut.click();
        return this;
    }

    public String getNameProfile() {
        return labelName.getValue();
    }

    public String getEmailProfile() {
        return labelLogin.getValue();
    }

    public PersonalAccountPage checkName(String name) {
        Assert.assertEquals(name.toLowerCase(), getNameProfile().toLowerCase());
        return this;
    }

    public PersonalAccountPage checkEmail(String email) {
        Assert.assertEquals(email.toLowerCase(), getEmailProfile().toLowerCase());
        return this;
    }

    public PersonalAccountPage checkTextProfile() {
        headForm.shouldHave(text("Профиль"));
        return this;
    }
}

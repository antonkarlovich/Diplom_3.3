package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    private final SelenideElement buttonAuthInAccount = $x(".//button[text()='Войти в аккаунт']");
    private final SelenideElement buttonPersonalAccount = $x(".//p[text()='Личный Кабинет']");
    private final SelenideElement constructor = $(byText("Конструктор"));
    private final SelenideElement headCollectToBurger = $x(".//h1[text()='Соберите бургер']");
    private final SelenideElement logoStellarBurgers = $(".AppHeader_header__logo__2D0X2");
    private final SelenideElement buns = $x(".//span[text()='Булки']");
    private final SelenideElement souses = $x(".//span[text()='Соусы']");
    private final SelenideElement fillings = $x(".//span[text()='Начинки']");
    private final SelenideElement sectionIngredients = $(".BurgerIngredients_ingredients__menuContainer__Xu3Mo");

    public MainPage openPage() {
        open(MAIN_PAGE_URL);
        return this;
    }

    public MainPage buttonAuthInAccountClick() {
        buttonAuthInAccount.click();
        return this;
    }

    public MainPage buttonPersonalAccountClick() {
        buttonPersonalAccount.click();
        return this;
    }

    public MainPage stellarBurgersClick() {
        logoStellarBurgers.click();
        return this;
    }

    public MainPage constructorClick() {
        constructor.click();
        return this;
    }


    public MainPage checkUserLogOut() {
        AuthPage authPage = new AuthPage();
        buttonPersonalAccountClick();
        authPage.shouldBeTextLogin();
        return this;
    }


    public MainPage bunsClick() {
        buns.click();
        return this;
    }

    public MainPage sousesClick() {
        souses.click();
        return this;
    }

    public MainPage fillingsClick() {
        fillings.click();
        return this;
    }

    public MainPage checkSectionIngredients(String ingredient) {
        sectionIngredients.shouldHave(text(ingredient));
        return this;
    }

    public MainPage checkTextCollectToBurger() {
        headCollectToBurger.shouldHave(text("Соберите бургер"));
        return this;
    }
}

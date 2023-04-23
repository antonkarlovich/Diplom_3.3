package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Objects;

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
    private final SelenideElement buns = $x(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div/div[1]");
    private final SelenideElement souses = $x(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div/div[2]");
    private final SelenideElement fillings = $x(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div/div[3]");
    private final SelenideElement sectionIngredients = $(".BurgerIngredients_ingredients__menuContainer__Xu3Mo");

    private final String CLASS_NAME_FOR_CHECK_SECTION = "tab_tab_type_current__2BEPc";

    private final By sectionSouses = By.xpath(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div/div[2]");

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

    public MainPage checkTextCollectToBurger() {
        headCollectToBurger.shouldHave(text("Соберите бургер"));
        return this;
    }

    public boolean clickAndCheckSectionSouses() {
        souses.click();
        return checkSection(souses);
    }

    public boolean clickAndCheckSectionBuns() {
        souses.click();
        buns.click();
        return checkSection(buns);
    }

    public boolean clickAndCheckSectionFilings() {
        fillings.click();
        return checkSection(fillings);
    }

    private boolean checkSection(SelenideElement section) {
        return section.getAttribute("class").contains(CLASS_NAME_FOR_CHECK_SECTION);
    }


}

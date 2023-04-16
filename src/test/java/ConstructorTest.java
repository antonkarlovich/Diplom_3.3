import org.junit.Test;
import pageobject.MainPage;

public class ConstructorTest {
    MainPage mainPage = new MainPage();
    @Test
    public void moveToBuns() {
        mainPage.openPage()
                .sousesClick()
                .bunsClick()
                .checkSectionIngredients("Булки");
    }
    @Test
    public void moveToSouses() {
        mainPage.openPage()
                .sousesClick()
                .checkSectionIngredients("Соусы");
    }
    @Test
    public void moveToFillings() {
        mainPage.openPage()
                .fillingsClick()
                .checkSectionIngredients("Начинки");
    }
}

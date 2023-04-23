import org.junit.Assert;
import org.junit.Test;
import pageobject.MainPage;

public class ConstructorTest {
    MainPage mainPage = new MainPage();
    @Test
    public void moveToBuns() {
        boolean result = mainPage.openPage()
                .clickAndCheckSectionBuns();
        Assert.assertTrue("Переключение на секцию соусы не выполнено", result);
    }
    @Test
    public void moveToSouses() {
        boolean result = mainPage.openPage()
                        .clickAndCheckSectionSouses();
        Assert.assertTrue("Переключение на секцию соусы не выполнено", result);
    }
    @Test
    public void moveToFillings() {
        boolean result = mainPage.openPage()
                .clickAndCheckSectionFilings();
        Assert.assertTrue("Переключение на секцию соусы не выполнено", result);
    }
}

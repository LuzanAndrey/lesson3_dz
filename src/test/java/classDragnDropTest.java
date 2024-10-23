import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class classDragnDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";;
    }
    @Test
    void DragnDropTest() {

        // открыть главную страницу
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // перемещение местами прямоугольников
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(150, 0).release().perform();

        // проверка, что прямоугольники поменялись

        $("#column-a").shouldHave(text("B"));}

    @Test
    void NewDragnDropTest() {

        // открыть главную страницу
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Проверить положение прямоугольников
        $("#column-a").shouldHave(text("A")); $("#column-b").shouldHave(text("B"));
        // перемещение местами прямоугольников
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));

        // проверка, что прямоугольники поменялись
        $("#column-a").shouldHave(text("B"));;

    }
}
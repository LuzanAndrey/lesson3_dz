import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class SelenideToJunit {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void SelenideToJunitTest() {
        // открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");
        //Перейти в WIKI
        $("#wiki-tab").click();
        // Нажать кнопку для 3 доп вариантов
        $(".wiki-more-pages-link button").click();
        // Убедиться, что есть SoftAssertions и нажать на него
        $$("#wiki-pages-box summary a").findBy(text("SoftAssertions")).shouldBe(visible).click();
        // Убедиться, что на странице есть пример кода JUnit
        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));

    }
}
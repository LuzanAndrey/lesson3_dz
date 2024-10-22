package github;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";;
    }
    @Test
    void SelenideToJunitTest() {

        open("https://github.com");
        //Навести курсор на Solutions
        $(".HeaderMenu-nav").$(byText("Solutions"))
                .hover();
        // В открывшемся дропдауне нажать на Enterprise
        $("[href=\"https://github.com/enterprise\"]").hover().click();
        // Убедиться, что на странице есть нужный текст
        $(".logged-out").shouldHave(text("he AI-powered developer platform."));



    }
}
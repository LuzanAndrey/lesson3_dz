import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideToJunit {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }
    @Test
    void andreiSolntsevShouldBeTheFirstContributor() {
        // открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");
        // подвести мышку к первому аватару из блока contributors
        $("#wiki-tab").click();



    }
}

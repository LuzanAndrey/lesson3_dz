import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Testdz {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {

        //Заполнение текстовых полей

        open("/automation-practice-form");
        $("#firstName").setValue("Andrey");
        $("#lastName").setValue("Luzan");
        $("#userEmail").setValue("adluzluzan@mail.ru");

        //Радио-кнопка

        $("label[for='gender-radio-2']").click();
        $("label[for='gender-radio-3']").click();
        $("label[for='gender-radio-1']").click();

        //Заполнение мобильного телефона

        $("#userNumber").setValue("1234567890");

        //Проставление даты рождения

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__month").$(byText("24")).click();

        //Предмет
        $("#subjectsInput").val("English").pressEnter();
        //хобби
        $("#hobbiesWrapper").findElement(byText("Sports")).click();
        //картинка
        $("#uploadPicture").uploadFromClasspath("тест.png");
        //Адрес
        $("#currentAddress").setValue("улица Пятая");
        //штат и город
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();
        //проверка
        $(".modal-body").shouldHave(text("Andrey Luzan"));
        $(".modal-body").shouldHave(text("adluzluzan@mail.ru"));
        $(".modal-body").shouldHave(text("1234567890"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("24 June,2024"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("English"));
        $(".modal-body").shouldHave(text("улица Пятая"));
        $(".modal-body").shouldHave(text("Haryana Karnal"));
        $(".modal-body").shouldHave(text("тест.png"));
    }
}
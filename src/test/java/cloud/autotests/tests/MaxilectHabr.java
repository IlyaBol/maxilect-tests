package cloud.autotests.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MaxilectHabr {
    String Textobject1 = "История программиста, создавшего компанию «",
            Textobject2 = "Maxilect",
            Textobject3 = "», на 100% работающую удаленно",
            Year = "2015";

    @Test()
    @DisplayName("Test Hubr Publication")
    @Feature("Header Test")
    @AllureId("5266")
    void testMaxilectPublicationForHabr() {
        step("Открыть url https://habr.com/", () ->
                open("https://habr.com/"));
        step("Нажать на иконку поиска", () ->
                $x("//*[@class='tm-svg-img tm-header-user-menu__icon tm-header-user-menu__icon_search tm-header-user-menu__icon_dark']").click());
        step("В строке поиска ввести maxilect", () ->
                $(".tm-input-text-decorated__input").setValue("maxilect").pressEnter());
        step("Найти публикацию по заданным параметрам", () ->
                $(".tm-article-snippet").shouldHave(text(Textobject1 + Textobject2 + Textobject3)));
        step("Перейти в публикацию", () ->
                $(".tm-article-snippet").shouldHave(text(Textobject1)).click());
    }

    @Test()
    @DisplayName("Test MaxilectCompany For Habr")
    @Feature("Header Test")
    @AllureId("5267")
    void TestMaxilectCompanyForHabr() {
        step("Открыть url https://habr.com/", () ->
                open("https://habr.com/"));
        step("Нажать на иконку поиска", () ->
                $x("//*[@class='tm-svg-img tm-header-user-menu__icon tm-header-user-menu__icon_search tm-header-user-menu__icon_dark']").click());
        step("В строке поиска ввести maxilect", () ->
                $(".tm-input-text-decorated__input").setValue("maxilect").pressEnter());
        step("Выбрать таб компании", () ->
                $x("//*[@class='tm-tabs__tab-item'][3]").click());
        step("Перейти в найденную компанию", () ->
                $x("//*[@class='tm-company-snippet__info']//*[text() = 'Maxilect']").click());
        step("Проверить что дата основания правильная", () ->
                $(".tm-description-list__body_variant-columns-nowrap").shouldHave(text(Year)));

    }
}


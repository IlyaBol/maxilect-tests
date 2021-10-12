package cloud.autotests.tests;

import cloud.autotests.config.App;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

      public class HeaderTest extends TestBase {
        @Test()
        @DisplayName("Sucsessful SOLUTIONS")
        @Feature("Header Test")
        @AllureId("5197")
        void headerTest() {
            step("Open https://maxilect.com/", () ->
                    open("https://maxilect.com/"));

            step("Select Ad Tech", () ->
                    $("#menu-item-626").click());
            step("Select Ad Tech", () ->
                    $x("//*[@class='Top-welcome']//*[text() = 'Ad Tech']").click());
            step("Select Fintech", () ->
                    $x("//*[@class='Top-welcome']//*[text() = 'Fintech']").click());
            step("Select QA Automation", () ->
                    $x("//*[@class='Top-welcome']//*[text() = 'QA Automation']").click());
            step("Select Blockchain", () ->
                    $x("//*[@class='Top-welcome']//*[text() = 'Blockchain']").click());
            step("Select Dedicated Team", () ->
                    $x("//*[@class='Top-welcome']//*[text() = 'Dedicated Team']").click());
            step("Select Turnkey solutions", () ->
                    $x("//*[@class='Top-welcome']//*[text() = 'Turnkey solutions']").click());
            step("Select Business Intelligence", () ->
                    $x("//*[@class='Top-welcome']//*[text() = 'Business Intelligence']").click());
            step("Select Machine Learning", () ->
                    $x("//*[@class='Top-welcome']//*[text() = 'Machine Learning']").click());
        }
    }


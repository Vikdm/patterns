package ru.netology.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static ru.netology.data.DataGenerator.*;
class CardDeliveryTest {

    @BeforeEach
    void openWebBank() {
        open("http://localhost:7777/");
    }

    @Test
    void testDelivery() {
        String planDate = generateDate(5);
        String planDate1 = generateDate(8);

        $("[data-test-id=city] input").val(getAdress());
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $x("//input[@type='tel']").val(planDate);
        $x("//input[@name='name']").val(getName());
        $x("//input[@name='phone']").val(getPhone());
        $("[data-test-id=agreement]").click();
        $(".button.button_view_extra.button_size_m").click();
        $("[data-test-id=success-notification]>div.notification__content")
                .shouldHave(Condition.text("Встреча успешно запланирована на " + planDate), Duration.ofSeconds(15))
                .shouldBe(visible);
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $x("//input[@type='tel']").val(planDate1);
        $(".button.button_view_extra.button_size_m").click();
        $(".button.button_view_extra.button_size_s").click();
        $("[data-test-id=success-notification]>div.notification__content")
                .shouldHave(Condition.text("Встреча успешно запланирована на " + planDate1), Duration.ofSeconds(15))
                .shouldBe(visible);
    }

    @Test
    void testDelivery1() {
        String planDate = generateDate(12);
        String planDate1 = generateDate(6);

        $("[data-test-id=city] input").val(getAdress());
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $x("//input[@type='tel']").val(planDate);
        $x("//input[@name='name']").val(getName());
        $x("//input[@name='phone']").val(getPhone());
        $("[data-test-id=agreement]").click();
        $(".button.button_view_extra.button_size_m").click();
        $("[data-test-id=success-notification]>div.notification__content")
                .shouldHave(Condition.text("Встреча успешно запланирована на " + planDate), Duration.ofSeconds(15))
                .shouldBe(visible);
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $x("//input[@type='tel']").val(planDate1);
        $(".button.button_view_extra.button_size_m").click();
        $(".button.button_view_extra.button_size_s").click();
        $("[data-test-id=success-notification]>div.notification__content")
                .shouldHave(Condition.text("Встреча успешно запланирована на " + planDate1), Duration.ofSeconds(15))
                .shouldBe(visible);
    }
}
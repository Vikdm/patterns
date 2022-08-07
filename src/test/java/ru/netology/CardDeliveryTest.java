package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
//import java.util.concurrent.TimeUnit;
//
//import static com.codeborne.selenide.Condition.*;
//import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

class CardDeliveryTest {

    private Faker faker;

    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @BeforeEach
    void openWebBank() {
        open("http://localhost:7777/");
        faker = new Faker(new Locale("ru"));
    }

    @Test
    void testDelivery() {
        String planDateMeet = generateDate(6);
        String planDateMeet1 = generateDate(12);

        $("[data-test-id=city] input").val(faker.address().city());
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $x("//input[@type='tel']").val(planDateMeet);
        $x("//input[@name='name']").val(faker.name().fullName());
        $x("//input[@name='phone']").val(faker.phoneNumber().phoneNumber());
        $("[data-test-id=agreement]").click();
        $(".button.button_view_extra.button_size_m.button_theme_alfa-on-white").click();
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $x("//input[@type='tel']").val(planDateMeet1);
        $(".button.button_view_extra.button_size_m").click();
        $(".button.button_view_extra.button_size_s").click();
        $(".notification__title")
                .shouldHave(Condition.text("Успешно!"), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void testDelivery1() {
        String planDateMeet = generateDate(10);
        String planDateMeet1 = generateDate(5);

        $("[data-test-id=city] input").val(faker.address().city());
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $x("//input[@type='tel']").val(planDateMeet);
        $x("//input[@name='name']").val(faker.name().fullName());
        $x("//input[@name='phone']").val(faker.phoneNumber().phoneNumber());
        $("[data-test-id=agreement]").click();
        $(".button.button_view_extra.button_size_m.button_theme_alfa-on-white").click();
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $x("//input[@type='tel']").val(planDateMeet1);
        $(".button.button_view_extra.button_size_m").click();
        $(".button.button_view_extra.button_size_s").click();
        $(".notification__title")
                .shouldHave(Condition.text("Успешно!"), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }
}
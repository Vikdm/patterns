package ru.netology;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

class CardDeliveryTest {

    private Faker faker;

    @BeforeEach
    void openWebBank() {
        open("http://localhost:7777/");
        faker = new Faker(new Locale("ru"));
    }

    @Test
    void testDelivery() {
        Configuration.timeout = 15;

        $("[data-test-id=city] input").val(faker.address().city());
        $x("//input[@type='tel']").val(faker.date().toString());
        $x("//input[@name='name']").val(faker.name().fullName());
        $x("//input[@name='phone']").val(faker.phoneNumber().phoneNumber());
        $("[data-test-id=agreement]").click();
        $(".button.button_view_extra.button_size_m.button_theme_alfa-on-white").click();
        $x("//input[@type='tel']").val(String.valueOf(faker.date().future(100, TimeUnit.DAYS)));
        $(".button.button_view_extra.button_size_m").click();
        $(".button.button_view_extra.button_size_s").click();
        $(byText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
    }

}
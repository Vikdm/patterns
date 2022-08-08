package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataGenerator {
    private static final Faker faker = new Faker(new Locale("ru"));

    private DataGenerator() {
    }

    public static String getAdress() {

        return faker.address().city();
    }

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


    public static String getName() {
        return faker.name().fullName();
    }

    public static String getPhone() {
        return faker.phoneNumber().phoneNumber();
    }


    @Value
    public static class RegistrationDto {
        String login;
        String password;
        String status;
    }
}
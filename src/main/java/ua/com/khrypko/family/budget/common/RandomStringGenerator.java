package ua.com.khrypko.family.budget.common;

import ua.com.khrypko.family.budget.user.registration.RegistrationServiceImpl;

import java.util.Random;

public final class RandomStringGenerator {

    private static final int RANDOM_STRING_LENGTH = 40;

    private RandomStringGenerator() {
    }

    public static String generateRandomUrlString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz_1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return sb.toString();
    }
}
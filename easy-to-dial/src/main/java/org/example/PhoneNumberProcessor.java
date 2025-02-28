package org.example;

import java.util.Map;
import java.util.Set;

/**
 * Utility class for functions related to phone number processing.
 */
public class PhoneNumberProcessor {

    private static final String PHONE_NUMBER_NON_DIGIT_ERROR_MESSAGE = "Phone number does not contain only digits";
    private static final String PHONE_NUMBER_LENGTH_ERROR_MESSAGE = "Phone number length should be between 10 and 15 digits";
    private static final String PHONE_NUMBER_EMPTY_ERROR_MESSAGE = "Phone number is null or empty";

    private static final String SYMBOLS_REGEX = "^\\+|[\\s\\-()]";
    private static final String DIGIT_ONLY_REGEX = "\\d+";

    private static final int MIN_PHONE_NUMBER_LENGTH = 10;
    private static final int MAX_PHONE_NUMBER_LENGTH = 15;

    private static final Map<Integer, Set<Integer>> ADJACENT_DIGITS = KeypadAdjacency.buildAdjacencyMap();

    /**
     * Deduces if a phone number is easy to dial based on digit adjacency.
     * @param phoneNumber the candidate number.
     * @return boolean true if easy to dial, false if not.
     */
    public static boolean isEasyToDial(String phoneNumber) {

        var cleanedNumber = cleanNumber(phoneNumber);

        for (int i = 0; i < cleanedNumber.length() - 1; i++) {

            //charAt will return the ASCII code, we minus 0 as the offset to get the actual number
            int currentDigit = cleanedNumber.charAt(i) - '0';
            int nextDigit = cleanedNumber.charAt(i+1) - '0';

            boolean adjacent = ADJACENT_DIGITS.get(currentDigit).contains(nextDigit);
            if (!adjacent) {
                return false;
            }
        }
        return true;
    }

    /**
     * Performs validation and sanitization of input
     * @param phoneNumber the inputted number
     * @return cleanedNumber
     */
    private static String cleanNumber(String phoneNumber) {

        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new RuntimeException(PHONE_NUMBER_EMPTY_ERROR_MESSAGE);
        }

        String cleanedNumber = phoneNumber.replaceAll(SYMBOLS_REGEX, "");

        if (!cleanedNumber.matches(DIGIT_ONLY_REGEX)) {
            throw new RuntimeException(PHONE_NUMBER_NON_DIGIT_ERROR_MESSAGE);
        }

        if (!(cleanedNumber.length() >= MIN_PHONE_NUMBER_LENGTH && cleanedNumber.length() <= MAX_PHONE_NUMBER_LENGTH)) {
            throw new RuntimeException(PHONE_NUMBER_LENGTH_ERROR_MESSAGE);
        }
        return cleanedNumber;
    }

}

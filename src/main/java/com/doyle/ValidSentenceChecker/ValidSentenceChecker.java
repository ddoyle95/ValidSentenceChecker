package main.java.com.doyle.ValidSentenceChecker;
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides functionality to check the validity of sentences based on specific rules.
 * It checks for proper punctuation, capitalisation, and the presence of numbers below a certain threshold.
 */

public class ValidSentenceChecker {
    private static final int MAX_NUMBER = 13;
    /*
     * Checks if given sentence is valid based on specific rules.
     * Rules include starting with an uppercase letter, ending with proper punctuation,
     * having an even number of quotes, no multiple periods, and no numbers below thirteen.
     *
     * @param sentence The sentence to check.
     * @return true if the sentence is valid, false otherwise.
     */
    public static boolean isValidSentence(String sentence) {
        // Check for null or empty input, and ensure the sentence starts with an uppercase letter.
        if (sentence == null || sentence.isEmpty() || !Character.isUpperCase(sentence.charAt(0))) {
            return false;
        }

        // Count quotes to ensure they are balanced (even number).
        int quotesCount = countQuotes(sentence);
        if (quotesCount % 2 != 0) {
            return false;
        }

        if (!isTerminatedProperly(sentence)) {
            return false;
        }

        if (hasMultiplePeriods(sentence) || containsPeriod(sentence)) {
            return false;
        }

        String [] words = sentence.split("\\s+|,\\s*|\\.\\s*");
        for (String word : words) {
            if (isInvalidNumber(word)) {
                return false;
            }
        }
        return true;
    }

    /*
     * Counts the number of quotation marks in the sentence.
     *
     * @param sentence The sentence to check
     * @return The number of quotation marks in the sentence.
     */
    private static int countQuotes(String sentence) {
        int count = 0;
        for (char c : sentence.toCharArray()) {
            if (c == '"') {
                count++;
            }
        }
        return count;
    }

    /*
     * Checks if sentence is terminated properly with a period, exclamation mark, or question mark.
     *
     * @param sentence The sentence to check.
     * @return true if sentence is terminated properly, false otherwise.
     */
    private static boolean isTerminatedProperly(String sentence) {
        if (sentence.isEmpty()) {
            return false;
        }

        char lastChar = sentence.charAt(sentence.length() - 1);
        return isSentenceTerminator(lastChar);
    }

    /*
     * Determines if a character is a valid sentence terminator.
     *
     * @param c The character to check.
     * @return true if the character is a sentence terminator, false otherwise.
     */
    private static boolean isSentenceTerminator(char c) {
        //Defined valid sentence terminators.
        return c == '.' || c == '?' || c == '!';
    }

    /*
     * Checks if the sentence contains more than one period.
     *
     * @param sentence The sentence to check.
     * @return true if the sentence has multiple periods, false otherwise.
     */
    private static boolean hasMultiplePeriods(String sentence) {
        int periodCount = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == '.') {
                periodCount++;
            }
        }
        return periodCount > 1;
    }

    /*
     * Checks if the sentence contains a period that is not at the end of the sentence.
     *
     * @param sentence The sentence to check.
     * @return true if a mid-sentence period is found, false otherwise.
     */
    private static boolean containsPeriod(String sentence) {
        String[] words = sentence.split("\\s+");
        for (String word : words) {
            if (word.contains(".") && !word.endsWith(".")) {
                return true;
            }
        }
        return false;
    }

    /*
     * Determines if a string represents a numeric value.
     *
     * @param word The string to check.
     * @return true if the string is a number, false otherwise.
     */
    private static boolean isNumber(String word) {
        //Attempt to parse word as an integer. If parsing succeeds, it is a number.
        try {
            Integer.parseInt(word);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
     * Checks if a word represents a number if it is below the defined threshold (thirteen).
     *
     * @param word The word to check.
     * @return true if the word is below the threshold, false otherwise.
     */
    private static boolean isInvalidNumber(String word) {
        if (isNumber(word)) {
            int num = Integer.parseInt(word);
            return num < MAX_NUMBER;
        }
        return false;
    }
}


package main.java.com.doyle.ValidSentenceChecker;

public class Main {
    public static void main (String[] args) {
        String[] sentences = {
                //Valid sentences
                "The quick brown fox said \"hello Mr lazy dog\".",
                "The quick brown fox said hello Mr lazy dog.",
                "One lazy dog is too few, 13 is too many.",
                "One lazy dog is too few, thirteen is too many.",
                "How many \"lazy dogs\" are there?",
                //Invalid sentences
                "The quick brown fox said \"hello Mr. lazy dog\".",
                "the quick brown fox said \"hello Mr lazy dog\".",
                "The quick brown fox said \"hello Mr lazy dog.\"",
                "One lazy dog is too few, 12 is too many.",
                "Are there 11, 12, or 13 lazy dogs?",
                "there is no punctuation in this sentence",
                ""
        };

        for (String sentence : sentences) {
            boolean isValid = ValidSentenceChecker.isValidSentence(sentence);
            System.out.println("\"" + sentence + "\" is " + (isValid ? "valid." : "invalid."));
        }
    }
}

package test.java.com.doyle.ValidSentenceCheckerTest;
import main.java.com.doyle.ValidSentenceChecker.ValidSentenceChecker;
import org.junit.Test;
import static org.junit.Assert.*;
public class ValidSentenceCheckerTest {

    @Test
    public void testValidSentences() {
        // Testing valid sentences
        assertTrue("Valid sentence",
                ValidSentenceChecker.isValidSentence("The quick brown fox said \"hello Mr lazy dog\"."));
        assertTrue("Valid Sentence without quotes",
                ValidSentenceChecker.isValidSentence("The quick brown fox said hello Mr lazy dog."));
        assertTrue("Valid sentence with number above threshold",
                ValidSentenceChecker.isValidSentence("One lazy dog is too few, 13 is too many."));
        assertTrue("Valid sentence with spelled out number & comma.",
                ValidSentenceChecker.isValidSentence("One lazy dog is too few, thirteen is too many."));
        assertTrue("Valid question format",
                ValidSentenceChecker.isValidSentence("How many \"lazy dogs\" are there?"));
    }

    @Test
    public void testInvalidSentences() {
        //Testing invalid sentences
        assertFalse("Invalid sentence with incorrect punctuation",
                ValidSentenceChecker.isValidSentence("The quick brown fox said \"hello Mr. lazy dog\"."));
        assertFalse("Invalid sentence starting with lowercase character",
                ValidSentenceChecker.isValidSentence("the quick brown fox said \"hello Mr lazy dog\"."));
        assertFalse("Invalid sentence with incorrect punctuation at the end",
                ValidSentenceChecker.isValidSentence("\"The quick brown fox said \"hello Mr lazy dog.\""));
        assertFalse("Invalid sentence with number below threshold",
                ValidSentenceChecker.isValidSentence("One lazy dog is too few, 12 is too many."));
        assertFalse("Invalid sentence with multiple numbers below threshold",
                ValidSentenceChecker.isValidSentence("Are there 11, 12, or 13 lazy dogs?"));
        assertFalse("Invalid sentence due to no punctuation",
                ValidSentenceChecker.isValidSentence("there is no punctuation in this sentence"));
        assertFalse("Invalid sentence: empty",
                ValidSentenceChecker.isValidSentence(""));
    }
}

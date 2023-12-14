# Valid Sentence Checker

## Description
A java application that checks if a sentence is valid based on specific grammatical rules.
These rules include:  
- The sentence starts with a capital letter.
- The sentence has an even number of quotation marks.
- The sentence ends with one of the following sentence termination characters ".", "?", "!"
- The sentence has no period characters other than the last character.
- Numbers below 13 are spelled out ("one", "two", "three", etc...)

## Usage
To run the `ValidSentenceChecker`, compile and execute the `Main` class. The application will test a series of sentences and output whether each is valid according to the specified rules.

## Examples
Input: "The quick brown fox said \"hello Mr lazy dog\"."
output: "The quick brown fox said "hello Mr lazy dog"." is valid.

Input: "the quick brown fox said \"hello Mr lazy dog\"."
Output: "The quick brown fox said "hello Mr. lazy dog"." is invalid.

## Running the Tests
To run the test, execute the `ValidSentenceCheckerTest` class. This contains a series of JUnit tests that validate various aspects of sentence validation.

## Contact
For any queries, please contact Daniel at ddoyle_95@outlook.com.

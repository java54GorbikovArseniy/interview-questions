package telran.interviews.test;

import org.junit.jupiter.api.Test;
import telran.interviews.AutoCompletion;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AutoCompletionTest {
    String[] words = {"ab", "ABC", "a", "avfdr", "aV", "aVV", "aaA"};
    String[] wordsAb = {"ab", "ABC"};
    String[] wordsAV = {"aV", "avfdr", "aVV"};
    String[] wordsAa = {"aaA"};

    @Test
    void test() {
        AutoCompletion autoCompletion = new AutoCompletion();
        for (String word : words){
            autoCompletion.addWord(word);
        }
        assertArrayEquals(wordsAb, autoCompletion.getVariants("ab"));
        assertArrayEquals(wordsAV, autoCompletion.getVariants("av"));
        assertArrayEquals(wordsAa, autoCompletion.getVariants("aa"));
    }
}
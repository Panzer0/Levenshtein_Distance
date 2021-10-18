import org.junit.jupiter.api.Assertions;

public class Test {
    @org.junit.jupiter.api.Test
    void test1() {
        String word1 = "ananas";
        String word2 = "banana";

        double retVal = Levenshtein.levQWERTY(word1, word2);

        Assertions.assertEquals(retVal, 2);
        assert(retVal == 2);

    }
    @org.junit.jupiter.api.Test
    void test2() {
        String word1 = "kiwi";
        String word2 = "kiwi";

        double retVal = Levenshtein.levQWERTY(word1, word2);

        Assertions.assertEquals(retVal, 0);
        assert(retVal == 0);
    }
    @org.junit.jupiter.api.Test
    void test3() {
        String word1 = "";
        String word2 = "kiwi";

        double retVal = Levenshtein.levQWERTY(word1, word2);

        Assertions.assertEquals(retVal, word2.length());
    }
    @org.junit.jupiter.api.Test
    void test4() {
        String word1 = "kiwi";
        String word2 = "";

        double retVal = Levenshtein.levQWERTY(word1, word2);

        Assertions.assertEquals(retVal, word1.length());
    }
    @org.junit.jupiter.api.Test
    void test5() {
        String word1 = "kiwi";
        String word2 = "ki wi";

        try {
            Levenshtein.levQWERTY(word1, word2);
            Assertions.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), "Words must consist of lowercase letters");
        }
    }
    @org.junit.jupiter.api.Test
    void test6() {
        String word1 = "kiwi";
        String word2 = "kiWi";

        try {
            Levenshtein.levQWERTY(word1, word2);
            Assertions.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), "Words must consist of lowercase letters");
        }
    }
    @org.junit.jupiter.api.Test
    void test7() {
        String word1 = "banana";
        String word2 = "barana";

        double retVal = Levenshtein.levQWERTY(word1, word2);

        Assertions.assertEquals(retVal, 1);
    }
    @org.junit.jupiter.api.Test
    void test8() {
        String word1 = "banana";
        String word2 = "nanana";

        double retVal = Levenshtein.levQWERTY(word1, word2);

        Assertions.assertEquals(retVal, 0.5);
    }
    @org.junit.jupiter.api.Test
    void test9() {
        String word1 = "banana";
        String word2 = "banan";

        double retVal = Levenshtein.levQWERTY(word1, word2);

        Assertions.assertEquals(retVal, 1);
    }
    @org.junit.jupiter.api.Test
    void test10() {
        String word1 = "banana";
        String word2 = "bananab";

        double retVal = Levenshtein.levQWERTY(word1, word2);

        Assertions.assertEquals(retVal, 1);
    }
}

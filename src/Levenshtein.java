import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class Levenshtein {
    static boolean isLowercaseAlpha(@NotNull String word) {
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) < 'a' || word.charAt(i) > 'z') return false;
        }
        return true;
    }

    static double levenshteinDistance(@NotNull String word1, String word2) throws IllegalArgumentException
    {
        if(!isLowercaseAlpha(word1) || !isLowercaseAlpha(word2)) {
            throw new IllegalArgumentException("Words must consist of lowercase letters");
        }
        // If either string is empty, the entire word must be rewritten or deleted
        if (word1.isEmpty() || word2.isEmpty())
        {
            return word1.isEmpty() ? word2.length() : word1.length();
        }
        // Deletion, achieved by skipping the lacking letter from word1 in word1
        double delete = levenshteinDistance(word1.substring(1), word2) + 1;
        // Insertion, achieved by skipping the lacking letter from word 1 in word2
        double insert = levenshteinDistance(word1, word2.substring(1)) + 1;
        // Replacement, achieved by assuming the lacking letter is replaced and skipping it in both words
        double replace = levenshteinDistance(word1.substring(1), word2.substring(1));
        double weight = new NeighbourChecker().isNeighbour(word1.charAt(0), word2.charAt(0)) ? 0.5 : 1;
        if(word1.charAt(0) != word2.charAt(0)) replace += weight;   // Replacement is free if both letters are equal
        return lowestOfThree(delete, insert, replace);  // Return the count from the most efficient path
    }

    static double lowestOfThree(double ... args)
    {
        Arrays.sort(args);
        return args[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1, word2;

        // Attempt until legal arguments are entered
        while(true) {
            try {
                System.out.println("Enter the first word");
                word1 = scanner.nextLine();
                System.out.println("Enter the second word");
                word2 = scanner.nextLine();

                System.out.println("The distance is " + levenshteinDistance(word1, word2));
                return;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
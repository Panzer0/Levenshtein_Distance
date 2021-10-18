import java.util.Arrays;
import java.util.Scanner;

public class Levenshtein {
    static int levenshteinDistance(String word1, String word2)
    {
        // If either string is empty, the entire word must be rewritten or deleted
        if (word1.isEmpty() || word2.isEmpty())
        {
            return word1.isEmpty() ? word2.length() : word1.length();
        }
        // Deletion, achieved by skipping the lacking letter from word1 in word1
        int delete = levenshteinDistance(word1.substring(1), word2) + 1;
        // Insertion, achieved by skipping the lacking letter from word 1 in word2
        int insert = levenshteinDistance(word1, word2.substring(1)) + 1;
        // Replacement, achieved by assuming the lacking letter is replaced and skipping it in both words
        int replace = levenshteinDistance(word1.substring(1), word2.substring(1));
        if(word1.charAt(0) != word2.charAt(0)) replace++;   // This action is free if the letters are equal

        return lowestOfThree(delete, insert, replace);  // Return the count from the most efficient path
    }

    static int lowestOfThree(int ... args)
    {
        Arrays.sort(args);
        return args[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word1, word2;

        System.out.println("Enter the first word");
        word1 = scanner.nextLine();
        System.out.println("Enter the second word");
        word2 = scanner.nextLine();

        System.out.println("The distance is " + levenshteinDistance(word1, word2));
    }
}
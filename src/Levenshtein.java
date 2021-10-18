import java.util.Scanner;

public class Levenshtein {

    public static int calculateDistance(String word1, String word2) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1, word2;

        System.out.println("Enter the first word");
        word1 = scanner.nextLine();
        System.out.println("Enter the first word");
        word2 = scanner.nextLine();

        System.out.println("The distance is " + calculateDistance(word1, word2));
    }
}

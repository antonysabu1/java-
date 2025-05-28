import java.util.*;

public class StringCharFrequency {

    public static void main(String[] args) {

        String inputStr, charToFind;
        int count = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string:");
        inputStr = sc.nextLine();

        System.out.println("Enter the character (letter, digit, or symbol):");
        charToFind = sc.nextLine();

        if (charToFind.length() != 1) {
            System.out.println("Please enter only one character.");
            return;
        }

        char targetChar = Character.toLowerCase(charToFind.charAt(0));
        String processedStr = inputStr.toLowerCase();

        for (int i = 0; i < processedStr.length(); i++) {
            if (processedStr.charAt(i) == targetChar) {
                count++;
            }
        }

        System.out.println("The frequency of '" + targetChar + "' in the string is: " + count);
    }
}


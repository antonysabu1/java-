import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose input type:");
            System.out.println("1. String");
            System.out.println("2. Number");
            System.out.println("Type 'stop' to exit.");
            System.out.print("Enter your choice (1 or 2): ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("stop")) {
                System.out.println("Program stopped.");
                break;
            }

            String input = "";
            if (choice.equals("1")) {
                System.out.print("Enter a string: ");
                input = sc.nextLine();
            } else if (choice.equals("2")) {
                System.out.print("Enter a number: ");
                input = sc.nextLine();
            } else {
                System.out.println("Invalid choice.");
                continue;
            }

            String original = input;
            int n = 0;
            int i = input.length() - 1;
            boolean isPalindrome = true;

            while (n < i) {
                if (input.charAt(n) != input.charAt(i)) {
                    isPalindrome = false;
                    break;
                }
                n++;
                i--;
            }

            if (isPalindrome) {
                System.out.println(original + " is a palindrome");
            } else {
                System.out.println(original + " is not a palindrome");
            }
        }

        sc.close();
    }
}

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter the numerator: ");
            int a = sc.nextInt();

            System.out.print("Enter the denominator: ");
            int b = sc.nextInt();

            try {
                int result = division(a, b);
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero is not possible.");
            } finally {
                System.out.println("Try-catch block executed.\n");
            }

            System.out.print("Do you want to continue? (y/n): ");
            choice = sc.next().toLowerCase().charAt(0);
            System.out.println();

        } while (choice == 'y');

        System.out.println("Program ended.");
        sc.close();
    }

    public static int division(int numerator, int denominator) throws ArithmeticException {
        return numerator / denominator;
    }
}

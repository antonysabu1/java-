import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input matrix 1 dimensions
        System.out.print("Enter rows and columns for Matrix 1: ");
        int rows1 = sc.nextInt();
        int cols1 = sc.nextInt();

        // Input matrix 2 dimensions
        System.out.print("Enter rows and columns for Matrix 2: ");
        int rows2 = sc.nextInt();
        int cols2 = sc.nextInt();

        // Matrix multiplication is only possible if cols1 == rows2
        if (cols1 != rows2) {
            System.out.println("❌ Matrix multiplication not possible. (columns of matrix 1 != rows of matrix 2)");
            return;
        }

        int[][] matrix1 = readMatrix(sc, rows1, cols1, "Matrix 1");
        int[][] matrix2 = readMatrix(sc, rows2, cols2, "Matrix 2");

        int[][] result = multiplyMatrices(matrix1, matrix2, rows1, cols1, cols2);

        System.out.println("\n✅ Resultant Matrix:");
        printMatrix(result);
        
        sc.close();
    }

    public static int[][] readMatrix(Scanner sc, int rows, int cols, String name) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements of " + name + " (" + rows + "x" + cols + "):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] multiplyMatrices(int[][] m1, int[][] m2, int r1, int c1, int c2) {
        int[][] result = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                int sum = 0;
                for (int k = 0; k < c1; k++) {
                    sum += m1[i][k] * m2[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%5d", val);
            }
            System.out.println();
        }
    }
}

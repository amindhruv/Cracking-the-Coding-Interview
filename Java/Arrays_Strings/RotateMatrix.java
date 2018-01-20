package Arrays_Strings;

import java.util.Scanner;

public class RotateMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows in n*n image matrix: ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        System.out.print("Enter " + n * n + " integers: ");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        sc.close();
        System.out.println("Before rotation:");
        printMatrix(matrix, n);
        rotateMatrix(matrix, n);
        System.out.println("After rotation:");
        printMatrix(matrix, n);
    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    private static void rotateMatrix(int[][] matrix, int n) {
        int first = 0, last = n - 1;
        while (first < last) {
            for (int i = first; i < last; i++) {
                int offset = i - first, temp = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = temp;
            }
            first++;
            last--;
        }
    }
}

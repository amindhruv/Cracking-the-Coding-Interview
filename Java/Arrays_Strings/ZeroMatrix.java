package Arrays_Strings;

import java.util.Scanner;

public class ZeroMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int row = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int column = sc.nextInt();
        int[][] matrix = new int[row][column];
        System.out.print("Enter " + row * column + " integers: ");
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                matrix[i][j] = sc.nextInt();
        sc.close();
        System.out.println("Original matrix:");
        printMatrix(matrix, row, column);
        zeroMatrix(matrix, row, column);
        System.out.println("Zero matrix:");
        printMatrix(matrix, row, column);
    }

    private static void zeroRow(int[][] matrix, int whichRow, int columnSize) {
        for (int column = 0; column < columnSize; column++)
            matrix[whichRow][column] = 0;
    }

    private static void zeroColumn(int[][] matrix, int whichColumn, int rowSize) {
        for (int row = 0; row < rowSize; row++)
            matrix[row][whichColumn] = 0;
    }

    private static void zeroMatrix(int[][] matrix, int row, int column) {
        boolean rowHasZero = false, columnHasZero = false;
        for (int i = 0; i < column; i++) {
            if (matrix[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                columnHasZero = true;
                break;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < column; i++)
            if (matrix[0][i] == 0) zeroColumn(matrix, i, row);
        for (int i = 1; i < row; i++)
            if (matrix[i][0] == 0) zeroRow(matrix, i, column);
        if (rowHasZero) zeroRow(matrix, 0, column);
        if (columnHasZero) zeroColumn(matrix, 0, row);
    }

    private static void printMatrix(int[][] matrix, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}

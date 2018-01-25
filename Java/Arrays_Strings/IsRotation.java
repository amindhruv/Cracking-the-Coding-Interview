package Arrays_Strings;

import java.util.Scanner;

public class IsRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two strings: ");
        String first = sc.next(), second = sc.next();
        sc.close();
        System.out.println(first + " is " + (isRotation(first, second) ? "" : "not ") + "rotation of " + second);
    }

    private static boolean isSubstring(String big, String small) {
        return big.contains(small);
    }

    private static boolean isRotation(String first, String second) {
        int length = first.length();
        if (length == second.length() && length != 0) {
            String firstTwice = first + first;
            return isSubstring(firstTwice, second);
        }
        return false;
    }
}

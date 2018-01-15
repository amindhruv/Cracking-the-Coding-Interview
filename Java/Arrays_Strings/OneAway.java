package Arrays_Strings;

import java.util.Scanner;

public class OneAway {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two strings: ");
        String first = sc.next(), second = sc.next();
        System.out.println(first + " is " + (isOneAway(first, second) ? "" : "not ") + "one edit away from " + second);
        sc.close();
    }

    private static boolean isOneAway(String first, String second) {
        if (first.length() < second.length()) return isOneAway(second, first);
        int n1 = first.length(), n2 = second.length(), i = 0, j = 0;
        if (n1 - n2 > 1) return false;
        boolean foundDifference = false;
        while (i < n1 && j < n2) {
            if (first.charAt(i) != second.charAt(j)) {
                if (foundDifference) return false;
                foundDifference = true;
                if (n1 == n2) j++;
            } else {
                j++;
            }
            i++;
        }
        return true;
    }
}

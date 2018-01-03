package Arrays_Strings;

import java.util.Scanner;

public class IsPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two strings: ");
        String first = sc.next(), second = sc.next();
        System.out.println(first + " is " + (isPermutation(first, second) ? "" : "not ") + "permutation of " + second);
        sc.close();
    }

    private static boolean isPermutation(String first, String second) {
        int n1 = first.length(), n2 = second.length();
        if (n1 != n2) return false;
        int[] counts = new int[128];
        for (int i = 0; i < n1; i++) {
            int val = first.charAt(i);
            counts[val]++;
        }
        for (int i = 0; i < n2; i++) {
            int val = second.charAt(i);
            counts[val]--;
            if (counts[val] < 0) return false;
        }
        return true;
    }
}
